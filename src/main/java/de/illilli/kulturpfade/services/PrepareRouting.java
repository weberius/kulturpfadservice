package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.JdbcRepository;
import de.illilli.kulturpfade.repository.PoiValuesRepository;

import java.util.List;

public class PrepareRouting {

    private List<RoutingData> dataList;

    public PrepareRouting() throws RoutingNotAvailableException {
        this("data");
    }

    public PrepareRouting(String id) throws RoutingNotAvailableException {

        // 1. get Data
        List<POI> beans = new PoiValuesRepository(id).find();
        // 2. add routing
        RoutingService routingService = new RoutingService();
        POI fromPOI = null;
        POI toPOI = null;
        for (int i = 0; i < beans.size(); i++) {
            if (AnchorType.isUnanchored(beans.get(i).getId())) {
                // intentionally left blank
                // ignore POI
            } else if (i == 0) {
                fromPOI = beans.get(i);
            } else {
                toPOI = beans.get(i);
                routingService.setPoints(fromPOI.getLat(), fromPOI.getLng(), toPOI.getLat(), toPOI.getLng());
                fromPOI = beans.get(i);
            }
        }
        this.dataList = routingService.getData();
    }

    List<RoutingData> getData() {
        return this.dataList;
    }
}
