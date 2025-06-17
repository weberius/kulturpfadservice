package de.illilli.kulturpfade.services;

import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.model.RoutingData;
import de.illilli.kulturpfade.repository.PoiValuesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PrepareRouting {

    private static Logger logger = LoggerFactory.getLogger(PrepareRouting.class);

    private List<RoutingData> dataList;

    public PrepareRouting(String id) throws RoutingNotAvailableException {

        try {
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
                } else if (AnchorType.isOutOfRoute(beans.get(i).getId())) {
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

        } catch (RoutingNotAvailableException e) {
            logger.error(e.toString());
        }
    }

    List<RoutingData> getData() {
        return this.dataList;
    }
}
