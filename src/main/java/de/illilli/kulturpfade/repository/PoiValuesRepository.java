package de.illilli.kulturpfade.repository;

import com.opencsv.bean.CsvToBeanBuilder;
import de.illilli.kulturpfade.model.POI;
import de.illilli.kulturpfade.services.RoutingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * As long as there is no database, use this implementation for getting POIs
 */
public class PoiValuesRepository implements JdbcRepository<POI> {

    private static Logger logger = LoggerFactory.getLogger(RoutingService.class);
    private String data;

    public PoiValuesRepository(String id) {
        if (id == null || id.isEmpty()) {
            this.data = "/muelheim.csv";
        } else {
            this.data = "/" + id + ".csv";
        }
    }

    @Override
    public List<POI> find() {

        List<POI> beans = new ArrayList<>();

        String fileName = "";

        if (this.getClass().getResource(this.data) == null) {
            return beans;
        } else {
            fileName = this.getClass().getResource(this.data).getFile();
        }

        try {
            beans = new CsvToBeanBuilder(new FileReader(fileName))
                    .withSeparator(';')
                    .withType(POI.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            logger.error(e.toString());
        }

        return beans;
    }
}
