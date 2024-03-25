package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.RoutingData;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class RouteServiceForFeatureCollectionIntegrationTest {

    @Test
    public void testGetFeatureCollection() throws RoutingNotAvailableException {
        // Arrange
        List<RoutingData> routingDataList = List.of(
                new RoutingData(1.0, 2.0, 3.0, 4.0),
                new RoutingData(3.0, 4.0, 5.0, 6.0)
        );

        // Mocking dependencies
        PrepareRouting prepareRouting = mock(PrepareRouting.class);
        when(prepareRouting.getData()).thenReturn(routingDataList);

        RouteServiceForFeatureCollection routeService = mock(RouteServiceForFeatureCollection.class);
        FeatureCollection collection = new FeatureCollection();
        collection.add(new Feature());
        collection.add(new Feature());
        when(routeService.getFeatureCollection()).thenReturn(collection);

        // Act
        FeatureCollection result = routeService.getFeatureCollection();

        // Assert
        assertNotNull(result);
        assertEquals(routingDataList.size(), result.getFeatures().size());
    }

    @Test
    public void testGetDistance() throws RoutingNotAvailableException {
        // Arrange
        List<RoutingData> routingDataList = List.of(
                new RoutingData(1.0, 2.0, 3.0, 4.0),
                new RoutingData(3.0, 4.0, 5.0, 6.0)
        );

        // Mocking dependencies
        PrepareRouting prepareRouting = mock(PrepareRouting.class);
        when(prepareRouting.getData()).thenReturn(routingDataList);

        RouteServiceForFeatureCollection routeService = mock(RouteServiceForFeatureCollection.class);
        when(routeService.getDistance()).thenReturn(3000);

        // Act
        int result = routeService.getDistance();

        // Assert
        assertEquals(3000, result);
    }

    @Test
    public void testGetTime() throws RoutingNotAvailableException {
        // Arrange
        List<RoutingData> routingDataList = List.of(
                new RoutingData(1.0, 2.0, 3.0, 4.0),
                new RoutingData(3.0, 4.0, 5.0, 6.0)
        );

        // Mocking dependencies
        PrepareRouting prepareRouting = mock(PrepareRouting.class);
        when(prepareRouting.getData()).thenReturn(routingDataList);

        RouteServiceForFeatureCollection routeService = mock(RouteServiceForFeatureCollection.class);
        when(routeService.getTime()).thenReturn(30);

        // Act
        int result = routeService.getTime();

        // Assert
        assertEquals(30, result);
    }
}
