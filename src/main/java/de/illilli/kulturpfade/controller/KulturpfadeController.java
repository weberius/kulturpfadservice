package de.illilli.kulturpfade.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.illilli.kulturpfade.services.PoiService;
import de.illilli.kulturpfade.services.RouteServiceForDataTable;
import de.illilli.kulturpfade.services.RouteServiceForFeatureCollection;
import org.geojson.FeatureCollection;
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

    @GetMapping("/poi/{id}")
    public String getAllPois(@PathVariable String id) throws Exception {

        // getting '<id>.geojosn'; need '<id>'
        id = id.substring(0, id.indexOf('.'));

        FeatureCollection featureCollection = new PoiService(id).getFeatureCollection();
        return new ObjectMapper().writeValueAsString(featureCollection);

    }

    @GetMapping("/route/{id}")
    public String getAllRoutes(@PathVariable String id) throws Exception {

        // getting '<id>.geojosn'; need '<id>'
        id = id.substring(0, id.indexOf('.'));

        FeatureCollection featureCollection = new RouteServiceForFeatureCollection(id).getFeatureCollection();
        return new ObjectMapper().writeValueAsString(featureCollection);

    }

    @GetMapping("/data/{id}")
    public String getData(@PathVariable String id) throws Exception {

        // getting '<id>.json'; need '<id>'
        id = id.substring(0, id.indexOf('.'));

        RouteServiceForDataTable service = new RouteServiceForDataTable(id);
        return new ObjectMapper().writeValueAsString(service.getData());

    }

}
