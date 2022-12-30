package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteServiceTest {

    @Test
    void testSomePois() throws Exception {

        RouteService service = new RouteService();
        FeatureCollection featureCollection = service.getFeatureCollection();
        String msg = new ObjectMapper().writeValueAsString(featureCollection);

//        int distance = 4646;
//        assertEquals(distance, service.getDistance());
        assertTrue(service.getDistance() > 0);

//        int time = 59;
//        assertEquals(time, service.getTime());
        assertTrue(service.getTime() > 0);

    }
}
