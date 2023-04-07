package de.illilli.kulturpfade.model;

import java.util.Objects;

public class Data {

    private String id;
    private String name;
    private String time;
    private String distance;

    public Data(String id, String name, String time, String distance) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
