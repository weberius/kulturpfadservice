package de.illilli.kulturpfade.services;

import com.graphhopper.util.shapes.GHPoint;
import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.JdbcRepository;
import de.illilli.kulturpfade.repository.PoiValuesRepository;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.springframework.stereotype.Component;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * Diese Klasse ermittelt für gegebene POIs Routen und stellte diese Daten als FeatureCollectcion zur Verfügung.
 */
@Component
public class RouteService {

    private FeatureCollection featureCollection = new FeatureCollection();
    private JdbcRepository<POI> repo = new PoiValuesRepository("");
    int distance = 0;
    int time = 0;

    public RouteService() throws RoutingNotAvailabteException {
        this("data");
    }

    public RouteService(String data) throws RoutingNotAvailabteException {

        // 1. get Data
        repo = new PoiValuesRepository(data);

        List<POI> beans = repo.find();
        // 2. add routing
        RoutingService routingService = new  RoutingService();
        POI fromPOI = null;
        POI toPOI = null;
        for (int i = 0; i < beans.size(); i++) {
            if (i == 0) {
                fromPOI = beans.get(i);
            } else {
                toPOI = beans.get(i);
                routingService.setPoints(fromPOI.getLat(), fromPOI.getLng(), toPOI.getLat(), toPOI.getLng());
                fromPOI = beans.get(i);
            }
        }
        // 3. Map to GeoJson
        List<RoutingData> dataList = routingService.getData();
        for (RoutingData routingData : dataList) {
            Feature feature = new Feature();
            // set line
            LineString lineString = new LineString();
            for (GHPoint point : routingData.getPoints()) {
                LngLatAlt element = new LngLatAlt(point.getLon(), point.getLat());
                lineString.add(element);
            }
            feature.setGeometry(lineString);
            // set properties to feature
            Map<String, Object> properties = new Hashtable<String, Object>();
            properties.put("distance", routingData.getDistance());
            properties.put("time", routingData.getTime());
            feature.setProperties(properties);
            // add feature to featurecollection
            featureCollection.add(feature);

            this.distance = this.distance +  routingData.getDistance();
            this.time = this.time + routingData.getTime();
        }
    }

    public FeatureCollection getFeatureCollection() {
        return featureCollection;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTime() {
        return this.time;
    }
}
