package de.illilli.kulturpfade;

import com.graphhopper.GraphHopper;
import com.graphhopper.config.CHProfile;
import com.graphhopper.config.Profile;

import java.io.File;

/**
 * Utility-Klasse zum Aufbau der GraphHopper-Datenbank während des Maven-Builds.
 * 
 * Diese Klasse wird während 'mvn install' oder 'mvn clean install' aufgerufen und:
 * - Sucht nach *.osm.pbf Dateien im osm/ Verzeichnis
 * - Prüft, ob bereits eine GraphHopper-Cache-Datenbank existiert
 * - Baut die Datenbank nur auf, wenn sie noch nicht existiert
 * - Überspringt den Aufbau, wenn die Datenbank bereits vorhanden ist
 */
public class BuildGraphHopperCache {

    private static final String OSM_DIRECTORY = "osm";
    private static final String PROFILE = "foot";
    private static final String VEHICLE = "foot";
    private static final String WEIGHTING = "fastest";
    private static final boolean TURNCOSTS = false;

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("GraphHopper Datenbank-Build");
        System.out.println("=================================================");

        try {
            File osmDir = new File(OSM_DIRECTORY);
            
            if (!osmDir.exists()) {
                System.out.println("INFO: OSM-Verzeichnis '" + osmDir.getAbsolutePath() + "' existiert nicht.");
                System.out.println("INFO: Erstelle Verzeichnis...");
                osmDir.mkdirs();
                System.out.println("INFO: Bitte legen Sie eine .osm.pbf Datei in das 'osm/' Verzeichnis.");
                System.out.println("INFO: GraphHopper-Datenbank wird beim ersten Start der Anwendung erstellt.");
                return;
            }

            File[] files = osmDir.listFiles();
            if (files == null || files.length == 0) {
                System.out.println("INFO: Keine Dateien im OSM-Verzeichnis gefunden.");
                System.out.println("INFO: Bitte legen Sie eine .osm.pbf Datei in das 'osm/' Verzeichnis.");
                System.out.println("INFO: GraphHopper-Datenbank wird beim ersten Start der Anwendung erstellt.");
                return;
            }

            // Suche nach .osm.pbf Datei
            File osmFile = null;
            File cacheDir = null;
            
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".osm.pbf")) {
                    osmFile = file;
                    String cacheName = file.getName().substring(0, file.getName().length() - 8) + "-cache";
                    cacheDir = new File(osmDir, cacheName);
                    break;
                }
            }

            if (osmFile == null) {
                System.out.println("INFO: Keine .osm.pbf Datei im 'osm/' Verzeichnis gefunden.");
                System.out.println("INFO: Bitte legen Sie eine .osm.pbf Datei in das Verzeichnis.");
                System.out.println("INFO: GraphHopper-Datenbank wird beim ersten Start der Anwendung erstellt.");
                return;
            }

            System.out.println("INFO: OSM-Datei gefunden: " + osmFile.getName());
            System.out.println("INFO: Größe: " + (osmFile.length() / (1024 * 1024)) + " MB");

            // Prüfe, ob Cache bereits existiert
            if (cacheDir.exists() && cacheDir.isDirectory() && cacheDir.list().length > 0) {
                System.out.println("INFO: GraphHopper-Cache existiert bereits: " + cacheDir.getName());
                System.out.println("INFO: Überspringe Datenbank-Aufbau.");
                System.out.println("=================================================");
                return;
            }

            // Cache existiert nicht oder ist leer - erstelle ihn
            System.out.println("INFO: GraphHopper-Cache wird erstellt: " + cacheDir.getName());
            System.out.println("WARNUNG: Dies kann je nach Dateigröße 5-15 Minuten dauern!");
            System.out.println("=================================================");

            long startTime = System.currentTimeMillis();

            GraphHopper hopper = new GraphHopper();
            hopper.setOSMFile(osmFile.getAbsolutePath());
            hopper.setGraphHopperLocation(cacheDir.getAbsolutePath());
            
            Profile foot = new Profile(PROFILE)
                    .setVehicle(VEHICLE)
                    .setWeighting(WEIGHTING)
                    .setTurnCosts(TURNCOSTS);
            hopper.setProfiles(foot);
            hopper.getCHPreparationHandler().setCHProfiles(new CHProfile(PROFILE));
            
            // Importiere und erstelle Cache
            hopper.importOrLoad();
            hopper.close();

            long duration = (System.currentTimeMillis() - startTime) / 1000;
            
            System.out.println("=================================================");
            System.out.println("SUCCESS: GraphHopper-Datenbank erfolgreich erstellt!");
            System.out.println("INFO: Dauer: " + duration + " Sekunden (" + (duration / 60) + " Minuten)");
            System.out.println("INFO: Cache-Verzeichnis: " + cacheDir.getAbsolutePath());
            System.out.println("=================================================");

        } catch (Exception e) {
            System.err.println("FEHLER beim Erstellen der GraphHopper-Datenbank:");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
