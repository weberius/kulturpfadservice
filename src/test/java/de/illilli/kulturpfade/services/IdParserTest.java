package de.illilli.kulturpfade.services;

import org.junit.jupiter.api.Test;
import org.locationtech.jts.util.Assert;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdParserTest {

    String[] testIds = {
            "frankenberg-p27-27",
            "homberg-p06-6",
            "stadt-p003-3",
            "stadt-o004-4"
    };

    @Test
    public void testIds() {

        String[] location = {"frankenberg", "homberg", "stadt", "stadt"};
        int[] id = {27, 6, 3, 4};
        int[] nr = {27, 6, 3, 4};
        String[] point = {"p", "p", "p", "o"};


        for (int i = 0; i < testIds.length; i++) {
            String idString = testIds[i];
            try {
                IdParser parser = new IdParser(idString);
                Assert.equals(location[i], parser.getLocation());
                Assert.equals(id[i], parser.getId());
                Assert.equals(nr[i], parser.getNr());
                Assert.equals(point[i], parser.getPoint());
            } catch (IllegalArgumentException e) {
                System.out.println("Fehler bei '" + idString + "': " + e.getMessage());
            }
        }
    }
}
