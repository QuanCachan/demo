package fr.mirabeau.demo.entity;

public class Zone {
    private String name;
    private String inventoryId;
    private  String id ;

    public Zone() {
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }
    public String getId() {
        return id;
    }
}
