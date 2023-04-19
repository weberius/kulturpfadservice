package de.illilli.kulturpfade.services;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RouteServiceForGPXIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForGPXIntegrationTest.class);

    @Test
    void testSomePois() throws Exception {

        RouteServiceForGPX routeService = new RouteServiceForGPX("b03-t04");

        logger.debug(routeService.getData().getRoutes().get(0).toString());

        int expected = 1;
        int actual = routeService.getData().getRoutes().size();

        assertEquals(expected, actual);
    }

}
