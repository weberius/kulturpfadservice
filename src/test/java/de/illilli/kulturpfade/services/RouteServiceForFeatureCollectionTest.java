package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteServiceForFeatureCollectionTest {

    @Test
    void testSomePois() throws Exception {

        RouteServiceForFeatureCollection service = new RouteServiceForFeatureCollection();
        FeatureCollection featureCollection = service.getFeatureCollection();
        String msg = new ObjectMapper().writeValueAsString(featureCollection);

        assertTrue(service.getDistance() > 0);
        assertTrue(service.getTime() > 0);

    }
}
