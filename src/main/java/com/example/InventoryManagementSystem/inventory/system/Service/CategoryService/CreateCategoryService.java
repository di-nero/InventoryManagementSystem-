package com.example.InventoryManagementSystem.inventory.system.Service.CategoryService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.CategoryDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.Category;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CreateCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object>  createCategory(CategoryDto categoryDto){
        Category category = mappers.toCategoryEntity(categoryDto);
        var result = categoryRepository.save(category);
       var saved = mappers.toCategoryDto(result);
       return ResponseEntity.status(HttpStatus.CREATED).body(SimpleResponse.responseBuilder(true ,"category saved successfully" , saved));
    }
}
