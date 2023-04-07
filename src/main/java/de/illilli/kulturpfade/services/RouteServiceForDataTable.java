package de.illilli.kulturpfade.services;

import com.graphhopper.util.Instruction;
import com.graphhopper.util.InstructionList;
import de.illilli.kulturpfade.model.Data;
import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.JdbcRepository;
import de.illilli.kulturpfade.repository.PoiValuesRepository;
import org.apache.commons.collections.list.AbstractLinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteServiceForDataTable {

    private static Logger logger = LoggerFactory.getLogger(RouteServiceForDataTable.class);

    private JdbcRepository<POI> repo = new PoiValuesRepository("");
    private List<Data> data = new ArrayList<>();

    public RouteServiceForDataTable() throws RoutingNotAvailableException {
        this("data");
    }

    public RouteServiceForDataTable(String id) throws RoutingNotAvailableException {
        // preparing for FeatureCollection
        int i = 0;
        List<POI> poiList = new PoiValuesRepository(id).find();

        int time = 0;
        int distance = 0;

        for (RoutingData routingData : new PrepareRouting(id).getData()) {

            POI poi = poiList.get(i);
            String poiId = poi.getId();
            String name = "null";
            if (poiId.length() >= 12 && !"null".equalsIgnoreCase(poi.getName())) {
                name = poi.getId().substring(12) + " " + poi.getName();
                time = time + routingData.getTime();
                distance = distance + routingData.getDistance();

                int hours = time / 60;
                int remainingMinutes = time % 60;
                String timeStr = String.format("%02d:%02d h", hours, remainingMinutes);

                int kilometers = distance / 1000;
                int remainingMeters = distance % 1000;
                String distanceStr = "" + String.format("%d,%03d km", kilometers, remainingMeters);

                this.data.add(new Data(poiId, name, timeStr, distanceStr));
            } else {
                time = time + routingData.getTime();
                distance = distance + routingData.getDistance();
            }

            i++;
        }
    }

    public List<Data> getData() {
        return this.data;
    }

}
