package de.illilli.kulturpfade.model;

import com.graphhopper.util.InstructionList;
import com.graphhopper.util.PointList;

import java.util.Objects;

public class RoutingData {

    private double fromLat;
    private double fromLon;
    private double toLat;
    private double toLon;

    private PointList points;
    private int distance;
    private int time;
    private InstructionList instructionList;

    public RoutingData(double fromLat, double fromLon, double toLat, double toLon){
        this.fromLat = fromLat;
        this.fromLon = fromLon;
        this.toLat = toLat;
        this.toLon = toLon;
    }

    public double getFromLat() {
        return this.fromLat;
    }

    public double getFromLon() {
        return this.fromLon;
    }

    public double getToLat() {
        return this.toLat;
    }

    public double getToLon() {
        return this.toLon;
    }

    public PointList getPoints() {
        return points;
    }

    public void setPoints(PointList points) {
        this.points = points;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public InstructionList getInstructionList() {
        return instructionList;
    }

    public void setInstructionList(InstructionList instructionList) {
        this.instructionList = instructionList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutingData that = (RoutingData) o;
        return Double.compare(that.fromLat, fromLat) == 0 && Double.compare(that.fromLon, fromLon) == 0 && Double.compare(that.toLat, toLat) == 0 && Double.compare(that.toLon, toLon) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fromLat, fromLon, toLat, toLon);
    }

    @Override
    public String toString() {
        return "RoutingData{" +
                "points=" + points +
                ", distance=" + distance +
                ", time=" + time +
                ", instructionList=" + instructionList +
                '}';
    }
}
