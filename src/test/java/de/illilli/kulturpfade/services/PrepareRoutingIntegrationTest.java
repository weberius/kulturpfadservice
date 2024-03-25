package de.illilli.kulturpfade.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.PoiValuesRepository;

/**
 * TODO: test is not ready. For that reason it is disabled. add data in testGetData
 */
public class PrepareRoutingIntegrationTest {

    private PrepareRouting prepareRouting;
    private PoiValuesRepository poiValuesRepository;
    private RoutingService routingService;

    @BeforeEach
    public void setUp() throws Exception {
        // Mock objects
        poiValuesRepository = mock(PoiValuesRepository.class);
        routingService = mock(RoutingService.class);

        // Sample data
        List<POI> pois = new ArrayList<>();
        // Add sample POIs here
        POI poi = new POI();
        poi.setLat(50.964372);
        poi.setLng(6.998312);
        pois.add(poi);

        poi = new POI();
        poi.setLat(50.966945);
        poi.setLng(7.000742);
        pois.add(poi);

        // Stubbing method calls
        when(poiValuesRepository.find()).thenReturn(pois);

        // Create PrepareRouting object with mocked dependencies
        prepareRouting = new PrepareRouting("data");
    }

    @Test
    @Disabled
    public void testGetData() throws RoutingNotAvailableException {
        // Sample data
        List<RoutingData> expectedData = new ArrayList<>();
        // Add expected routing data here
//        RoutingData routingData = new RoutingData(50.964372,6.998312,50.966945,7.000742);
//        routingData.setPoints(null);
//        expectedData.add(routingData);

        // Stubbing method calls
        when(routingService.getData()).thenReturn(expectedData);

        // Call the method being tested
        List<RoutingData> actualData = prepareRouting.getData();

        // Assertion
        assertEquals(expectedData, actualData);
    }

    // Add more tests as needed
}
