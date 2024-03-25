package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.Culturalpath;
import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RouteServiceForDataTableIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForDataTableIntegrationTest.class);


    @Test
    public void testGetData() throws RoutingNotAvailableException {
        // Arrange
        // Sample POI list
        List<POI> poiList = List.of(
                new POI("poi1", "POI 1", 1.0, 2.0),
                new POI("poi2", "POI 2", 3.0, 4.0)
                // Add more sample POIs here if needed
        );

        // Sample routing data list
        List<RoutingData> routingDataList = List.of(
                new RoutingData(1.0, 2.0, 3.0, 4.0),
                new RoutingData(3.0, 4.0, 5.0, 6.0)
                // Add more sample routing data here if needed
        );

        // Act
        RouteServiceForDataTable routeService = new RouteServiceForDataTable(poiList, routingDataList);
        List<Culturalpath> result = routeService.getData();

        // Assert
        // Verify that the result is not null
        assertNotNull(result);
        // Verify that the result contains the expected number of items
        assertNotEquals(poiList.size(), result.size());
        // Verify that each item in the result has non-null values
        for (Culturalpath path : result) {
            assertNotNull(path.getId());
            assertNotNull(path.getName());
            assertNotNull(path.getTime());
            assertNotNull(path.getDistance());
        }
    }}
