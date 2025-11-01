package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;
    public ResponseEntity<Object> createProduct(ProductDto productDto){
        Product product = mappers.toProductEntity(productDto);
        var result = productRepository.save(product);
        var data = mappers.toProductDto(result);

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.responseBuilder(true, "Product created successfully" , data));
    }
}
