package de.illilli.kulturpfade.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import de.illilli.kulturpfade.services.PoiService;

/**
 * Tests the api; empty '/data/data.geojson' is provieded in webapp-directory
 */
@AutoConfigureMockMvc
@ContextConfiguration(classes = {KulturpfadeController.class, PoiService.class})
@WebMvcTest
public class KulturpfadeControllerIntegrationTest {

    private static Logger logger = LoggerFactory.getLogger(KulturpfadeControllerIntegrationTest.class);

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetPois() throws Exception {

        MvcResult result =
                mockMvc.perform(MockMvcRequestBuilders.get("/data/data.geojson")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        int expected = 200;
        int actual = result.getResponse().getStatus();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetRoutes() throws Exception {

        MvcResult result =
                mockMvc.perform(MockMvcRequestBuilders.get("/data/data.geojson")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andReturn();

        int expected = 200;
        int actual = result.getResponse().getStatus();
        assertEquals(expected, actual);
    }

}
