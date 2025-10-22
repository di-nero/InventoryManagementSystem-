package com.example.InventoryManagementSystem.inventory.system.Service.ProductService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.SimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UpdateProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<Object> updateProduct(Long id , ProductDto productDto){
        var product = productRepository.findById(id);
        if(product.isEmpty())
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(SimpleResponse.responseBuilder(false , "invalid id" , null));
        var prod = product.get();

        var category = categoryRepository.findByName(productDto.getCategoryName());
        if(category.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SimpleResponse.responseBuilder(false , "invalid category" , null));
        var cate = category.get();


        prod.setName(productDto.getName());
        prod.setPrice(productDto.getPrice());
        prod.setQuantity(productDto.getQuantity());
        prod.setCategory(cate);

        var result = productRepository.save(prod);
        var data = mappers.toProductDto(result);
        return ResponseEntity.status(HttpStatus.OK).body(SimpleResponse.responseBuilder(true , "category updated" , data));


    }

}
