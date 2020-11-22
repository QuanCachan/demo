package fr.mirabeau.demo.service;

import fr.mirabeau.demo.entity.Inventory;

public interface InventoryService {
    /**
     * Get inventory by given name
     * @param name : Inventory name
     * @return Inventory with the same name
     */
    Inventory getInventoryByName(String name);
}
