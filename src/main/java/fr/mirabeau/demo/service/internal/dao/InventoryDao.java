package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Inventory;

public interface InventoryDao {
    /**
     * Get inventory by given name
     * @param name : Inventory name
     * @return Inventory with the same name
     */
    Inventory getInventoryByName(String name);
}
