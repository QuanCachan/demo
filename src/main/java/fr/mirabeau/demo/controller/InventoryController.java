package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("inventories")
public class InventoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/{name}")
    public List<Inventory> getInventoryByName(@PathVariable String name) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("get an Inventory by name");
        }
        return inventoryService.getInventoryByName(name);
    }

    @GetMapping()
    public List<Inventory> getAllInventories() {
        LOGGER.info("get all Inventories");
        return inventoryService.getAllInventories();
    }

    @PostMapping("")
    public Inventory createInventory(@RequestBody Inventory inventory) {
        LOGGER.info("create inventory",inventory);
        return inventoryService.createInventory(inventory);
    }

    @DeleteMapping(value = "/inventories/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable String id) {

        return inventoryService.deleteInventory(id);

        // return new ResponseEntity<String>(id, HttpStatus.OK);
    }
}
