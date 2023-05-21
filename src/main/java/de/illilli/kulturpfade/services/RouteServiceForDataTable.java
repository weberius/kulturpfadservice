package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.Culturalpath;
import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.JdbcRepository;
import de.illilli.kulturpfade.repository.PoiValuesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteServiceForDataTable {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForDataTable.class);

    private JdbcRepository<POI> repo = new PoiValuesRepository("");
    private List<Culturalpath> data = new ArrayList<>();

    public RouteServiceForDataTable() throws RoutingNotAvailableException {
        this("data");
    }

    public RouteServiceForDataTable(String id) throws RoutingNotAvailableException {
        // preparing for FeatureCollection
        List<POI> poiList = new PoiValuesRepository(id).find();
        List<RoutingData> routingDataList = new PrepareRouting(id).getData();

        int i = 0;
        int time = 0;
        int distance = 0;

        POI poi = poiList.get(0);
        String poiId = poi.getId();
        String name = poi.getId().substring(12) + " " + poi.getName();
        String timeStr = String.format("%02d:%02d h", 0, 0);
        String distanceStr = "" + String.format("%d,%03d km", 0, 0);
        this.data.add(new Culturalpath(poiId, name, timeStr, distanceStr));

        for (RoutingData routingData : routingDataList) {

            poi = poiList.get(i+1);
            poiId = poi.getId();

            if (poiId.length() >= 12 && !"null".equalsIgnoreCase(poi.getName())) {
                name = poi.getId().substring(12) + " " + poi.getName();
                time = time + routingData.getTime();
                distance = distance + routingData.getDistance();

                int hours = time / 60;
                int remainingMinutes = time % 60;
                timeStr = String.format("%02d:%02d h", hours, remainingMinutes);

                int kilometers = distance / 1000;
                int remainingMeters = distance % 1000;
                distanceStr = "" + String.format("%d,%03d km", kilometers, remainingMeters);

                this.data.add(new Culturalpath(poiId, name, timeStr, distanceStr));
            } else {
                time = time + routingData.getTime();
                distance = distance + routingData.getDistance();
            }

            i++;
        }


    }

    public List<Culturalpath> getData() {
        return this.data;
    }

}
