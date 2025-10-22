package com.example.InventoryManagementSystem.inventory.system.Service.CategoryService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.CategoryDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object> updateCategory(Long id , CategoryDto categoryDto){
        var category = categoryRepository.findById(id);
        if (category.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SimpleResponse.responseBuilder(false ,"invalid id" , null));
        var result = category.get();
        result.setName(categoryDto.getName());
        result.setDescription(categoryDto.getDescription());
        var data =categoryRepository.save(result);
        var outcome = mappers.toCategoryDto(data);
        return ResponseEntity.ok(SimpleResponse.responseBuilder(true ,"Category updated" , outcome));
    }
}
