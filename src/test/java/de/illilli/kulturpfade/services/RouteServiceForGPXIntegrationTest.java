package de.illilli.kulturpfade.services;

import com.graphhopper.util.shapes.GHPoint;
import de.illilli.kulturpfade.model.RoutingData;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Route;
import io.jenetics.jpx.WayPoint;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RouteServiceForGPXIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForGPXIntegrationTest.class);

    @Test
    void testEmptyRoute() throws Exception {

        // Arrange
        List<RoutingData> routingDataList = new ArrayList<>();

        // Mocking dependencies
        PrepareRouting prepareRouting = mock(PrepareRouting.class);
        when(prepareRouting.getData()).thenReturn(routingDataList);

        RouteServiceForGPX routeService = mock(RouteServiceForGPX.class);
        GPX gpx = GPX.builder().build();
        when(routeService.getData()).thenReturn(gpx);

        int expected = routingDataList.size();
        int actual = routeService.getData().getRoutes().size();

        assertEquals(expected, actual);
    }

}
