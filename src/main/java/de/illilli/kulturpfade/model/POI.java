package de.illilli.kulturpfade.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class POI {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private double lat;

    @CsvBindByPosition(position = 3)
    private double lng;

    @CsvBindByPosition(position = 4)
    private int zoom;

    private double[] latlng;

    public POI(){
        // empty
    }

    public POI(String id, String name, double lat, double lng){
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POI poi = (POI) o;
        return Double.compare(poi.lat, lat) == 0 && Double.compare(poi.lng, lng) == 0 && Objects.equals(id, poi.id) && Objects.equals(name, poi.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lat, lng);
    }

    @Override
    public String toString() {
        return "POI{" +
                "id='" + id + '\'' +
                ", title='" + name + '\'' +
                ", lat=" + lat +
                ", lon=" + lng +
                '}';
    }
}
