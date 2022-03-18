package de.illilli.kulturpfade.services;

import com.opencsv.bean.CsvToBeanBuilder;
import de.illilli.kulturpfade.model.POI;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Component
public class PoiService {

    private static Logger logger = LoggerFactory.getLogger(RoutingService.class);

    private FeatureCollection featureCollection = new FeatureCollection();

    public PoiService() throws FileNotFoundException {
        // 1. get Data
        String fileName = this.getClass().getResource("/kulturpfad-muelheim.csv").getFile();

        List<POI> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withSeparator(';')
                .withType(POI.class)
                .build()
                .parse();

        // 2. Map to GeoJson

        for (POI poi : beans) {
            Feature feature = new Feature();
            Point point = new Point();
            LngLatAlt element = new LngLatAlt(poi.getLon(), poi.getLat());
            point.setCoordinates(element);
            feature.setGeometry(point);
            Map<String, Object> properties = new Hashtable<String, Object>();
            properties.put("id", poi.getId());
            properties.put("title", poi.getTitle());
            feature.setProperties(properties);
            featureCollection.add(feature);
        }

    }

    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }

}
