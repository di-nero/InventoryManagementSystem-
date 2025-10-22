package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetLowStockProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<List<ProductDto>> getLowStockProduct(int thresholdId){
        var result = productRepository.findByQuantityLessThanEqual(thresholdId).stream().map(product -> mappers.toProductDto(product)).toList();
        return ResponseEntity.ok(result);
    }
}
