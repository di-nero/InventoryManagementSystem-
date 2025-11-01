package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object> deleteProduct(Long id){
        var result = productRepository.findById(id);
        if (result.isEmpty())
            return ResponseEntity.ok().body(ApiResponse.responseBuilder(false , "invalid id" , null));
        else
            productRepository.deleteById(id);

        return ResponseEntity.ok().body(ApiResponse.responseBuilder(true , "product deleted" , null));
    }
}
