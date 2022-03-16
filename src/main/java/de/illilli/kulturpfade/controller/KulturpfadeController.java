package de.illilli.kulturpfade.controller;

import de.illilli.kulturpfade.services.PoiService;
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

}
