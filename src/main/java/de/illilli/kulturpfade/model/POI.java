package de.illilli.kulturpfade.model;

import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class POI {

    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByPosition(position = 1)
    private String title;

    @CsvBindByPosition(position = 2)
    private double lat;

    @CsvBindByPosition(position = 3)
    private double lon;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        POI poi = (POI) o;
        return Double.compare(poi.lat, lat) == 0 && Double.compare(poi.lon, lon) == 0 && Objects.equals(id, poi.id) && Objects.equals(title, poi.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, lat, lon);
    }

    @Override
    public String toString() {
        return "POI{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
