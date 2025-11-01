package com.example.InventoryManagementSystem.inventory.system.Service.CategoryService;

import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object> deleteCategory(Long id){
        //check if category id exists in DB if not category  not found
        var catId = categoryRepository.findById(id).orElse(null);
        if (catId == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.responseBuilder(false , "category not found" , null));

        //check if there is a product under the category if not safe to delete
        var hasProduct = productRepository.existsByCategory(catId);
        if (hasProduct)
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.responseBuilder(false , "cannot delete category that still has product" , null));

        categoryRepository.delete(catId);

        return ResponseEntity.ok(ApiResponse.responseBuilder(true , "category deleted" , null));
    }
}
