package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

public class PoiServiceTest {

    @Test
    void testSomePois() throws Exception {
        PoiService service = new PoiService();
        FeatureCollection featureCollection = service.getFeatureCollection();

        String msg = new ObjectMapper().writeValueAsString(featureCollection);
        System.out.println("##### " + msg);
    }
}
