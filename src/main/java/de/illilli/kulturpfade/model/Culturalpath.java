package de.illilli.kulturpfade.model;

import java.util.Objects;

public class Culturalpath {

    private String id;
    private String name;
    private String time;
    private String distance;

    public Culturalpath(String id, String name, String time, String distance) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Culturalpath that = (Culturalpath) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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
