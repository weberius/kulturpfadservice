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
public class RouteServiceForFeatureCollection {

    private FeatureCollection featureCollection = new FeatureCollection();
    private JdbcRepository<POI> repo = new PoiValuesRepository("");
    int distance = 0;
    int time = 0;

    /**
     * service defalut value;
     *
     * @throws RoutingNotAvailableException
     */
    public RouteServiceForFeatureCollection() {
    }

    public RouteServiceForFeatureCollection(String id) throws RoutingNotAvailableException {
        calculateFeatureCollection(new PrepareRouting(id).getData());
    }

    public void calculateFeatureCollection(List<RoutingData> routingDataList) {
        for (RoutingData routingData : routingDataList) {
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
            properties.put("distance", routingData.getDistance() + " m");
            properties.put("time", routingData.getTime() + " min");
            properties.put("type", "route");
            feature.setProperties(properties);
            // add feature to featurecollection
            this.featureCollection.add(feature);
            this.distance = this.distance + routingData.getDistance();
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
