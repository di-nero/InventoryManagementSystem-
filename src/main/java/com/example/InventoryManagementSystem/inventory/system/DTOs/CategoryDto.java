package com.example.InventoryManagementSystem.inventory.system.DTOs;




public class CategoryDto {
    private String name;
    private String description;

    public CategoryDto(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CategoryDto() {
    }
}
