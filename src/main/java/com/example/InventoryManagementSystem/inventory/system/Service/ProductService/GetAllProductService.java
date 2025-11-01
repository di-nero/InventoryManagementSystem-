package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;


import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return ResponseEntity.ok(productRepository
                .findAll()
                .stream()
                .map(product -> mappers.toProductDto(product))
                .toList());
    }
}
