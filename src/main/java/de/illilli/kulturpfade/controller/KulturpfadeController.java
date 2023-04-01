package de.illilli.kulturpfade.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.illilli.kulturpfade.services.PoiService;
import de.illilli.kulturpfade.services.RouteService;
import de.illilli.kulturpfade.services.RoutingService;
import org.geojson.FeatureCollection;
import org.geojson.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class KulturpfadeController {

    private static Logger logger = LoggerFactory.getLogger(KulturpfadeController.class);

    @Autowired
    private PoiService poiService;

    @GetMapping("/poi/{data}")
    public String getAllPois(@PathVariable String data) throws Exception {

        FeatureCollection featureCollection = new PoiService(data).getFeatureCollection();
        return new ObjectMapper().writeValueAsString(featureCollection);

    }

    @GetMapping("/route/{data}")
    public String getAllRoutes(@PathVariable String data) throws Exception {

        FeatureCollection featureCollection = new RouteService(data).getFeatureCollection();
        return new ObjectMapper().writeValueAsString(featureCollection);
    }

}
