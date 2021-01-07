package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InventoryController.class)
class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InventoryService inventoryService;

    @Test
    void getInventoryByName() {

    }

    @Test
    void getAllInventories() throws Exception {
        Mockito.when(inventoryService.getAllInventories())
                .thenReturn(Collections.emptyList());

        RequestBuilder request = MockMvcRequestBuilders.get("/inventories/").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request).andReturn();

        Mockito.verify(inventoryService).getAllInventories();

    }

    @Test
    void createInventory() {
    }

    @Test
    void deleteInventory() {
    }
}