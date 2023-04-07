package de.illilli.kulturpfade.model;

import java.util.ArrayList;
import java.util.List;

public class DataTable {

    public List<Data> data = new ArrayList<>();

    public DataTable() {
        this.data = new ArrayList<>();
    }

    public void addData(String id, String name, String time, String distance) {
        Data data = new Data(id, name, time, distance);
        this.data.add(data);
    }

    public List<Data> getData() {
        return this.data;
    }

}
