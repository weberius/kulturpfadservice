package de.illilli.kulturpfade.services;

import com.graphhopper.GHRequest;
import com.graphhopper.GHResponse;
import com.graphhopper.GraphHopper;
import com.graphhopper.ResponsePath;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;
import de.illilli.kulturpfade.model.RoutingData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Der RoutingService erstellt auf Basis von zwei räumlichen Punkten
 * eine Fussgängernavigation auf Basis von OSM Datenmaterial und
 * mit Hilfe einer Graphopper Routing Engine. Hierfür wird unterstellt,
 * dass sich im Verzeichnis /osm eine kompatible *.pbf - Datei befindet.
 * Befindet sie sich dort nicht, wird eine RoutingNotAvailabte Exception
 * geworfen. Befinden sich die angefragten Punkte ausserhalb des
 * verarbeitbaren Bereiches, wird ebenfalls eine RoutingNotAvailable Exception
 * geworfen.
 */
public class RoutingService {

    private static Logger logger = LoggerFactory.getLogger(RoutingService.class);

    public static String PROFILE = "foot";
    public static String VEHICLE = "foot";
    public static String WEIGHTING = "fastest";
    public static boolean TURNCOSTS = false;
    public static Locale LOCALE = Locale.GERMAN;

    private static GraphHopper hopper;
    private List<RoutingData> data;

    private String osmDataDirectory;

    /**
     * Erstellt einen RoutingService mit dem Standard OSM-Verzeichnis "osm"
     */
    public RoutingService() throws RoutingNotAvailableException {
        this("osm");
    }

    /**
     * Erstellt einen RoutingService mit einem spezifischen OSM-Verzeichnis
     * @param osmDataDirectory Pfad zum OSM-Datenverzeichnis (relativ oder absolut)
     */
    public RoutingService(String osmDataDirectory) throws RoutingNotAvailableException {
        this.osmDataDirectory = osmDataDirectory;

        String osmFileLocation = "";
        String graphhopperLocation = "";

        try {
            // OSM-Verzeichnis im Projekt-Root verwenden
            File osmDir = new File(osmDataDirectory);
            if (!osmDir.exists()) {
                throw new RoutingNotAvailableException("OSM data directory '" + osmDir.getAbsolutePath() + "' not found");
            }
            
            File[] files = osmDir.listFiles();
            if (files == null) {
                throw new RoutingNotAvailableException("Cannot read OSM data directory '" + osmDir.getAbsolutePath() + "'");
            }
            
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".osm.pbf")) {
                    osmFileLocation = file.getAbsolutePath();
                    graphhopperLocation = file.getParent()
                            + File.separator
                            + file.getName().substring(0, file.getName().length() - 8)
                            + "-cache";
                    break;
                }
            }
            
            if (osmFileLocation.isEmpty()) {
                throw new RoutingNotAvailableException("No .osm.pbf file found in directory '" + osmDir.getAbsolutePath() + "'");
            }
        } catch (NullPointerException e) {
            throw new RoutingNotAvailableException("Error accessing OSM data directory: " + e.getMessage());
        }

        // initialize Data
        data = new ArrayList<>();
        // start with graphhopper
        if (hopper == null) {
            hopper = new GraphHopper();
            // set osm-File-Location
            hopper.setOSMFile(osmFileLocation);
            // specify where to store graphhopper files
            hopper.setGraphHopperLocation(graphhopperLocation);
            // see docs/core/profiles.md to learn more about profiles
            Profile foot = new Profile(PROFILE).setVehicle(VEHICLE).setWeighting(WEIGHTING).setTurnCosts(TURNCOSTS);
            hopper.setProfiles(foot);
            // this enables speed mode for the profile we called car
            hopper.getCHPreparationHandler().setCHProfiles(new CHProfile(PROFILE));
            // now this can take minutes if it imports or a few seconds for loading of course this is dependent on the area you import
            hopper.importOrLoad();
        }

    }

    /**
     * Diese Methode fuehrt das eigentliche Routing durch. Sie kann mehrfach aufgerufen werden.
     * Das Ergebnis eines Routings wird an das data Objekt angehängt und steht über getData() zur Verfügung.
     * Wenn eine Strecke bereits erstellt wurde, wird das Routing nicht wiederholt, sondern ignoriert.
     * Unterschiedliche Routings müssen nicht, können aber gleiche Start- oder Endpunkte haben.
     * @param fromLat
     * @param fromLon
     * @param toLat
     * @param toLon
     */
    public void setPoints(double fromLat, double fromLon, double toLat, double toLon) throws RoutingNotAvailableException {

        RoutingData routingData = new RoutingData(fromLat, fromLon, toLat, toLon);
        if (data.contains(routingData)) {
            logger.error("points already routed, skip this routing");
            return;
        }

        // simple configuration of the request object
        // we have to specify which profile we are using
        // define the language for the turn instructions
        GHRequest req = new GHRequest(fromLat, fromLon, toLat, toLon).setProfile(PROFILE).setLocale(LOCALE);
        GHResponse rsp = hopper.route(req);

        // use the best path, see the GHResponse class for more possibilities.
        ResponsePath path;
        try {
            path = rsp.getBest();
        } catch(RuntimeException e) {
            throw new RoutingNotAvailableException(e.getMessage());
        }

        // points, distance in meters and time in millis of the full path
        double distance = path.getDistance();
        int meter = new BigDecimal(distance).setScale(0, RoundingMode.UP).intValue();
        int minutes = Math.round(path.getTime() / 60000) + 1;
        // set data
        routingData.setPoints(path.getPoints());
        routingData.setDistance(meter);
        routingData.setTime(minutes);
        routingData.setInstructionList(path.getInstructions());
        // add data to list
        this.data.add(routingData);
    }

    /**
     * sämtliche Daten können her abgerufen werden.
     * @return
     */
    public List<RoutingData> getData() {
        return data;
    }
}
