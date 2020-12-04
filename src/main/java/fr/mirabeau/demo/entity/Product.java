package fr.mirabeau.demo.entity;

import java.util.List;

public class Product {
    private String id;
    private String name;
    private String reference;
    private String physicalState;
    private String unit;
    private String bookedQuantity;
    private List<String> securityPictogramList;
    private String description;
    private String comment;
    private String attachment;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getPhysicalState() {
        return physicalState;
    }

    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getBookedQuantity() {
        return bookedQuantity;
    }

    public void setBookedQuantity(String bookedQuantity) {
        this.bookedQuantity = bookedQuantity;
    }

    public List<String> getSecurityPictogramList() {
        return securityPictogramList;
    }

    public void setSecurityPictogramList(List<String> securityPictogramList) {
        this.securityPictogramList = securityPictogramList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
