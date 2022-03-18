package de.illilli.kulturpfade.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.illilli.kulturpfade.services.PoiService;
import de.illilli.kulturpfade.services.RouteService;
import de.illilli.kulturpfade.services.RoutingService;
import org.geojson.FeatureCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class KulturpfadeController {

    @Autowired
    private PoiService poiService;

    @GetMapping("/poi")
    public String getAllPois() {

        String allPois = poiService.getData();
        return allPois;

    }

    @GetMapping("/route")
    public String getAllRoutes() throws Exception {
        FeatureCollection featureCollection = new RouteService().getFeatureCollection();
        return new ObjectMapper().writeValueAsString(featureCollection);
    }

}
