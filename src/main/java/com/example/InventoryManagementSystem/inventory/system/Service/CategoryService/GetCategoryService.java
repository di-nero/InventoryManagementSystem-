package com.example.InventoryManagementSystem.inventory.system.Service.CategoryService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.CategoryDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mappers mappers;
    public ResponseEntity<List<CategoryDto>> getCategory(){
        return ResponseEntity.ok(categoryRepository
                .findAll()
                .stream()
                .map(category -> mappers.toCategoryDto(category))
                .toList());
    }

}
