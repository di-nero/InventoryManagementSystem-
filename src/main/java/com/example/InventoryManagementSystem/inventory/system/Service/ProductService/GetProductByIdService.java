package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GetProductByIdService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;


    public ResponseEntity<Object> getProductById(Long id){
        var result = productRepository.findById(id);
        if(result.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SimpleResponse.responseBuilder(false , "product of id " + id + " does not exist" , null));
        else {
            var data = mappers.toProductDto(result.get());
            return ResponseEntity.ok(SimpleResponse.responseBuilder(true , "product found" , data));
        }
    }

}
