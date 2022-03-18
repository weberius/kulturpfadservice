package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

public class RouteServiceTest {

    @Test
    void testSomePois() throws Exception {
        RouteService service = new RouteService();
        FeatureCollection featureCollection = service.getFeatureCollection();

        String msg = new ObjectMapper().writeValueAsString(featureCollection);
        System.out.println("##### " + msg);
    }
}
