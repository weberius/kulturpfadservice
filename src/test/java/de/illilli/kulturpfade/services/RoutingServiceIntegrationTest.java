package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.RoutingData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>Die Tests unterstellen, dass OSM Daten für den Regierungsbezirk Köln
 * vorhanden sind. Damit sie laufen, wird die Datei 'koeln-regbez-latest.osm.pbf'
 * im Verzeichnis 'src/main/resources' erwartet. Dies ist die Voraussetzung für
 * die Nutzung der Routing Engine von Graphhopper.</p>
 * <p>Die Datei kann bei der Geofabrik heruntergelanden werden:
 * <a href="https://download.geofabrik.de/europe/germany/nordrhein-westfalen.html">
 *     Download OpenStreetMap data for this region: Nordrhein-Westfalen</a></p>
 * <p>Liegt die Datei nicht vor, werden alle Tests, die darauf aufbauen übersprungen.</p>
 */
public class RoutingServiceIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(RoutingServiceIntegrationTest.class);

    /**
     * Testet das Routing zwischen zwei PUnkten.
     * @throws Exception
     */
    @Test
    void testSimpleRoutingService() throws Exception {

        try {
            RoutingService routing = new RoutingService();
            double fromLat = 50.962099;
            double fromLon = 6.999916;
            double toLat = 50.966876738072266;
            double toLon = 7.00067371620458;

            routing.setPoints(fromLat, fromLon, toLat, toLon);

            List<RoutingData> data = routing.getData();
            Assertions.assertNotNull(data);
        } catch (RoutingNotAvailabteException e) {
            logger.error(e.getMessage());
        }

    }

    /**
     * Testet, ob eine Route ggf bereits geroutet wurde. Wenn ja, wird das Routing für diese
     * Route übersprungen. Es wird kein zusätzlicher Datensatz dem RoutingService.data Objekt
     * hinzugefügt.
     * @throws Exception
     */
    @Test
    void testPointsAlreadyRouted() throws Exception {

        try {
            RoutingService routing = new RoutingService();
            double fromLat = 50.962099;
            double fromLon = 6.999916;
            double toLat = 50.966876738072266;
            double toLon = 7.00067371620458;

            routing.setPoints(fromLat, fromLon, toLat, toLon);
            routing.setPoints(fromLat, fromLon, toLat, toLon);

            int expected = 1;
            int actual = routing.getData().size();

            Assertions.assertEquals(expected, actual);
        } catch (RoutingNotAvailabteException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Testet een Weg einmal hin und dann wieder zurück. Überprüft nur, ob zwei Routen erstelltn wurden.
     * Prüft nicht auf Inhalt der Routen.
     * @throws Exception
     */
    @Test
    void test2Routes() throws Exception {

        try {
            RoutingService routing = new RoutingService();
            double fromLat = 50.962099;
            double fromLon = 6.999916;
            double toLat = 50.966876738072266;
            double toLon = 7.00067371620458;

            routing.setPoints(fromLat, fromLon, toLat, toLon);
            routing.setPoints(toLat, toLon, fromLat, fromLon);

            int expected = 2;
            int actual = routing.getData().size();

            Assertions.assertEquals(expected, actual);
        } catch (RoutingNotAvailabteException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Teste, dass eine RoutingNotAvailabteException Excepton geworfen wird, wenn zwischen den Punkten nicht
     * geroutet werden kann, weil sie ausserhalb des OSM-Datensatzes liegen.
     * @throws Exception
     */
    @Test
    void testFarAway() throws Exception {

        Assertions.assertThrows(RoutingNotAvailabteException.class, () -> {

            RoutingService routing = new RoutingService();
            double fromLat = 50.962099;
            double fromLon = 6.999916;
            double toLat = 51.107309;
            double toLon = 6.938838;

            routing.setPoints(fromLat, fromLon, toLat, toLon);
        });

    }

    @Test
    void testNoRoutingAvailabe() throws Exception {

        String osmDataName = "duesseldorf-regbez-latest";
        Assertions.assertThrows(RoutingNotAvailabteException.class, () -> {
            new RoutingService(osmDataName);
        });

    }

}
