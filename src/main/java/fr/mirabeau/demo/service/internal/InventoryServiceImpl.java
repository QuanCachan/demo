package fr.mirabeau.demo.service.internal;

import fr.mirabeau.demo.entity.Inventory;
import fr.mirabeau.demo.service.InventoryService;
import fr.mirabeau.demo.service.internal.dao.InventoryDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {
    private final InventoryDao inventoryDao;

    public InventoryServiceImpl(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    @Override
    public List<Inventory> getInventoryByName(String name) {
        return inventoryDao.getInventoryByName(name);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryDao.getAllInventories();
    }
}
