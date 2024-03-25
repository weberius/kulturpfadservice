package de.illilli.kulturpfade.services;

import com.graphhopper.util.shapes.GHPoint;
import de.illilli.kulturpfade.model.RoutingData;
import io.jenetics.jpx.GPX;
import io.jenetics.jpx.Route;
import io.jenetics.jpx.WayPoint;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RouteServiceForGPX {

    private GPX gpx;

    public RouteServiceForGPX() {
    }

    public RouteServiceForGPX(String id) throws RoutingNotAvailableException {
        calculateGpx(id);
    }

    private void calculateGpx(String id) throws RoutingNotAvailableException {
        List<WayPoint> wayPointList = new ArrayList<>();

        for (RoutingData routingData : new PrepareRouting(id).getData()) {
            for (GHPoint point : routingData.getPoints()) {
                WayPoint wayPoint = WayPoint.of(point.getLat(), point.getLon());
                wayPointList.add(wayPoint);
            }
        }
        Route route = Route.of(wayPointList);

        gpx = GPX.builder()
                .addRoute(route)
                .build();

        Path path = Path.of("./" + id + ".gpx");
        try {
            GPX.write(gpx, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GPX getData(){
        return this.gpx;
    }
}
