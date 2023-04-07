package de.illilli.kulturpfade.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RouteServiceForDataTableIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForDataTableIntegrationTest.class);


    @Test
    void testSomePois() throws Exception {

        RouteServiceForDataTable service = new RouteServiceForDataTable("b03-t06");
        logger.debug(service.getData().toString());

        assertFalse(service.getData().isEmpty());

    }

}
