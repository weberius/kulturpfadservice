package de.illilli.kulturpfade.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.illilli.kulturpfade.model.DataTable;
import de.illilli.kulturpfade.model.Gallery;
import de.illilli.kulturpfade.services.*;
import org.geojson.FeatureCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

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
        DataTable data = new DataTable(service.getData());
        return new ObjectMapper().writeValueAsString(data);

    }

    @GetMapping("/gpx/{id}")
    public ResponseEntity getGpx(@PathVariable String id) throws Exception {

        // getting '<id>.json'; need '<id>'
        id = id.substring(0, id.indexOf('.'));

        // save gpx-file to filesystem
        new RouteServiceForGPX(id);

        // read from filesystem
        String filePath = "./" + id + ".gpx";
        InputStream inputStream = new FileInputStream(new File(filePath));
        InputStreamResource inputStreamResource = new InputStreamResource(inputStream);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(Files.size(Paths.get(filePath)));

        // return gpx file
        return new ResponseEntity(inputStreamResource, headers, HttpStatus.OK);

    }

    @GetMapping("/gallery/{id}")
    public String getGallery(@PathVariable String id) throws Exception {

        // getting '<id>.josn'; need '<id>'
        id = id.substring(0, id.indexOf('.'));

        List<Gallery> galleryList = new GalleryService(id).getList();
        return new ObjectMapper().writeValueAsString(galleryList);

    }

}
