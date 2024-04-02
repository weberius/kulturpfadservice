package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.repository.JdbcRepository;
import de.illilli.kulturpfade.repository.PoiValuesRepository;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Component
public class PoiService {

    private static Logger logger = LoggerFactory.getLogger(RoutingService.class);

    private FeatureCollection featureCollection = new FeatureCollection();
    private JdbcRepository<POI> repo = new PoiValuesRepository("");

    public PoiService() {
        this("data");
    }

    public PoiService(String id) {

        // 1. get Data
        repo = new PoiValuesRepository(id);
        List<POI> beans = repo.find();
        // 2. Map to GeoJson
        int i = 1;
        for (POI poi : beans) {

            Feature feature = new Feature();
            Point point = new Point();
            LngLatAlt element = new LngLatAlt(poi.getLng(), poi.getLat());
            point.setCoordinates(element);
            feature.setGeometry(point);
            Map<String, Object> properties = new Hashtable<String, Object>();
            properties.put("id", poi.getId());
            String name = poi.getName();
            String nr = "";
            String nrname = "";

            if (poi.getId() != null && poi.getId().length() >= 15) {
                int beginIndex = poi.getId().lastIndexOf("-") + 1;
                nr = poi.getId().substring(beginIndex);
                name = poi.getName();
                nrname = nr + name;
            }

            properties.put("nr", nr);
            properties.put("name", name);
            properties.put("nrname", nrname);
            properties.put("type", "poi");
            feature.setProperties(properties);
            if (poi.getName() != null && !poi.getName().equalsIgnoreCase("null")) {
                featureCollection.add(feature);
            }
        }

    }

    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }

}
