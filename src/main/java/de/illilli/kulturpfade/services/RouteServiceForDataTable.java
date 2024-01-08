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
        this(new PoiValuesRepository(id).find(), new PrepareRouting(id).getData());
    }

    RouteServiceForDataTable(List<POI> poiList, List<RoutingData> routingDataList) throws RoutingNotAvailableException {

        int i = 0;
        int time = 0;
        int distance = 0;

        String timeStr = String.format("%02d:%02d h", 0, 0);
        String distanceStr = "" + String.format("%d,%03d km", 0, 0);

        for (POI poi : poiList) {
            String poiId = poi.getId();
            int beginIndex = poi.getId().lastIndexOf("-") + 1;
            String name = poi.getId().substring(beginIndex) + " " + poi.getName();

            if (i == 0) {
                Culturalpath path = new Culturalpath(poiId, name, timeStr, distanceStr);
                this.data.add(path);
            }

            if (AnchorType.isAnchor(poiId)) {
                for (RoutingData routingData : routingDataList) {
                    if (poi.getLat() == routingData.getToLat()
                            && poi.getLng() == routingData.getToLon()) {

                        time = time + routingData.getTime();
                        distance = distance + routingData.getDistance();

                        int hours = time / 60;
                        int remainingMinutes = time % 60;
                        timeStr = String.format("%02d:%02d h", hours, remainingMinutes);
                        int kilometers = distance / 1000;
                        int remainingMeters = distance % 1000;
                        distanceStr = "" + String.format("%d,%03d km", kilometers, remainingMeters);

                        Culturalpath path = new Culturalpath(poiId, name, timeStr, distanceStr);
                        this.data.add(path);
                        break;
                    }
                }
            } else if (AnchorType.isBase(poiId)) {
                for (RoutingData routingData : routingDataList) {
                    if (poi.getLat() == routingData.getToLat()
                            && poi.getLng() == routingData.getToLon()) {
                        time = time + routingData.getTime();
                        distance = distance + routingData.getDistance();
                        break;
                    }
                }
            } else if (AnchorType.isUnanchored(poiId)) {
                Culturalpath path = new Culturalpath(poiId, name, "", "");
                this.data.add(path);
            }
            i++;
        }
    }

    public List<Culturalpath> getData() {
        return this.data;
    }

}
