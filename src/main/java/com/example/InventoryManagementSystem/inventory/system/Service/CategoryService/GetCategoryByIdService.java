package com.example.InventoryManagementSystem.inventory.system.Service.CategoryService;

import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCategoryByIdService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mappers mappers;
    public ResponseEntity<Object> getCategoryById(Long id){
        var result = categoryRepository.findById(id).orElse(null);
        if (result != null) {
            var data = mappers.toCategoryDto(result);
            return ResponseEntity.ok(ApiResponse.responseBuilder(true , "category found" , data));
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.responseBuilder(false , "invalid Id" , null));
    }
}
