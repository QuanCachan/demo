package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = DemoApplication.class)
@DataMongoTest
@ExtendWith(SpringExtension.class)
class InventoryControllerITTest {

    @Test
    void getInventoryByName() {

    }

    @Test
    void getAllInventories() {

    }

    @Test
    void createInventory() {
    }

    @Test
    void deleteInventory() {
    }
}