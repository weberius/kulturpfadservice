package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PoiServiceTest {

    @Test
    void testSomePois() throws Exception {
        PoiService service = new PoiService();
        FeatureCollection featureCollection = service.getFeatureCollection();

        String msg = new ObjectMapper().writeValueAsString(featureCollection);
        assertTrue(msg.contains("FeatureCollection"));
    }
}
