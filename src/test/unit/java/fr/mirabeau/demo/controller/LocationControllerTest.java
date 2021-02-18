package fr.mirabeau.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import fr.mirabeau.demo.entity.Location;
import fr.mirabeau.demo.service.LocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

@ExtendWith(SpringExtension.class)
@WebMvcTest(LocationController.class)
class LocationControllerTest {
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), StandardCharsets.UTF_8);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    LocationService locationService;

    @Test
    void getInventoryByName() {

    }

    @Test
    void getAllInventories() throws Exception {
        Mockito.when(locationService.getAllLocations())
                .thenReturn(Collections.emptyList());

        RequestBuilder request = MockMvcRequestBuilders.get("/inventories/").accept(MediaType.APPLICATION_JSON);
        mockMvc.perform(request).andReturn();

        Mockito.verify(locationService).getAllLocations();
    }

    @Test
    void createInventory() throws Exception {
        Location newInvent = new Location("4","Nice", "another inventory in France", "01/02/2021");

        Mockito.when(locationService.createLocation(newInvent))
                .thenReturn(newInvent);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String newInventInStr = ow.writeValueAsString(newInvent);
        RequestBuilder request = MockMvcRequestBuilders.post("/inventories/")
                .contentType(APPLICATION_JSON_UTF8)
                .content(newInventInStr);
        mockMvc.perform(request).andReturn();

        ArgumentCaptor<Location> argument = ArgumentCaptor.forClass(Location.class);
        Mockito.verify(locationService).createLocation(argument.capture());
    }

    @Test
    void deleteInventory() {

    }
}