package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetTotalValueOfAllProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object> getTotalValueOfAllProduct(){
        Double total = productRepository.getTotalProductValue();
        var result = ApiResponse.responseBuilder(true , "total value calculated" , total);
        return ResponseEntity.ok(total != null ? result : 0.0);
    }

}
