package fr.mirabeau.demo.controller;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/{name}")
    public List<Inventory> getInventoryByName(@PathVariable String name) {
        return inventoryService.getInventoryByName(name);
    }

    @GetMapping()
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }
}
