package de.illilli.kulturpfade.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteServiceForDataTableTest {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForDataTableTest.class);


    @Test
    void testSomePois() throws Exception {

        RouteServiceForDataTable service = new RouteServiceForDataTable();
        logger.debug(service.getData().toString());

    }

}
