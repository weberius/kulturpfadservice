package de.illilli.kulturpfade.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is needed for getting an Data-Structure like
 *
 * <code>
 *     {"data":[
 *     ...
 *     ]}
 * </code>
 */
public class DataTable {

    List<Culturalpath> data = new ArrayList<>();

    public DataTable() {
        this.data = new ArrayList<>();
    }

    public DataTable(List<Culturalpath> data) {
        this.data = data;
    }

    public void setData(List<Culturalpath> data) {
        this.data = data;
    }

    public List<Culturalpath> getData() {
        return this.data;
    }

}
