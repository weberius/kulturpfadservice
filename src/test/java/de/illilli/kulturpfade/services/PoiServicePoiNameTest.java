package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoiServicePoiNameTest {

    /**
     * Teste, dass der letzte Teil der ìd die Anfangszeichenkette des Namens ist.
     * @throws Exception
     */
    @Test
    void testSomePois() throws Exception {
        PoiService service = new PoiService();
        FeatureCollection featureCollection = service.getFeatureCollection();

        List<Feature> features = featureCollection.getFeatures();
        for (Feature feature : features) {
            String id = feature.getProperty("id");
            int beginIndex = id.lastIndexOf("-") +1;
            String number = id.substring(beginIndex);
            String name = feature.getProperty("name");
            assertTrue(name.startsWith(number));
        }

    }

}
