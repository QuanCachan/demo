package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.service.internal.dao.InventoryDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@WebMvcTest(InventoryService.class)
class InventoryServiceTest {

    private final List<Inventory> db = new ArrayList<>();

    @MockBean
    InventoryService inventoryService;

    @MockBean
    InventoryDao inventoryDao;

    @BeforeEach
    void init() {
        Inventory invent1 = new Inventory("1","Paris", "first inventory in France", "01/01/2020");
        Inventory invent2 = new Inventory("2","Lyon", "second inventory in France", "01/10/2020");
        Inventory invent3 = new Inventory("3","Antony", "best inventory in France", "01/01/2021");
        this.db.add(invent1);
        this.db.add(invent2);
        this.db.add(invent3);
    }

    @Test
    void getInventoryByName() {

    }

    @Test
    void getAllInventories() throws Exception {
        Mockito.when(inventoryService.getAllInventories())
                .thenReturn(this.db);


    }

    @Test
    void createInventory() throws Exception {
        Inventory newInvent = new Inventory("4","Nice", "another inventory in France", "01/02/2021");

        Mockito.when(inventoryService.createInventory(newInvent))
                .thenReturn(newInvent);

    }

    @Test
    void deleteInventory() {
    }
}