package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Inventory;

import java.util.List;

public interface InventoryService {
    /**
     * Get inventory by given name
     *
     * @param name : Inventory name
     * @return Inventory with the same name
     */
    List<Inventory> getInventoryByName(String name);

    /**
     * Get all Inventories
     *
     * @return all inventories
     */
    List<Inventory> getAllInventories();
}
