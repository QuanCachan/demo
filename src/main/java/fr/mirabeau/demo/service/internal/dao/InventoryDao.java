package fr.mirabeau.demo.service.internal.dao;

import fr.mirabeau.demo.entity.Inventory;

import java.util.List;

public interface InventoryDao {
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
     * @return all Inventories
     */
    List<Inventory> getAllInventories();
}
