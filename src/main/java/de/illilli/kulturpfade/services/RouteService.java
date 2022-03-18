package de.illilli.kulturpfade.services;

import org.geojson.FeatureCollection;
import org.springframework.stereotype.Component;

/**
 * Diese Klasse ermittelt für gegebene POIs Routen und stellte diese Daten als FeatureCollectcion zur Verfügung.
 */
@Component
public class RouteService {

    private FeatureCollection featureCollection = new FeatureCollection();

    public RouteService() {

        // 1. read from csv file

        // add routing

        // change to geoJson
    }

    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }
}
