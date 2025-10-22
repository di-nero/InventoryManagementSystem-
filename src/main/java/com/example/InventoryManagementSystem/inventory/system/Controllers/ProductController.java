package com.example.InventoryManagementSystem.inventory.system.Controllers;

import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.SimpleResponse;
import com.example.InventoryManagementSystem.inventory.system.Service.ProductService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Products")
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;
    @Autowired
    private CreateProductService createProductService;
    @Autowired
    private GetAllProductService getAllProductService;
    @Autowired
    private GetProductByIdService getProductById;
    @Autowired
    private UpdateProductService updateProductService;
    @Autowired
    private DeleteProductService deleteProductService;
    @Autowired
    private GetLowStockProductService getLowStockProductService;
    @Autowired
    private GetTotalValueOfAllProductService getTotalValueOfAllProductService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct(){
        return  getAllProductService.getAllProduct();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAProduct(@PathVariable Long id){
       return getProductById.getProductById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductDto productDto){
        return createProductService.createProduct(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto){
     return updateProductService.updateProduct(id , productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id){
       return deleteProductService.deleteProduct(id);
    }

    @GetMapping("/low-stock")
    public ResponseEntity<List<ProductDto>> getLowStockProduct(@RequestParam(defaultValue = "10") int thresholdId){
       return getLowStockProductService.getLowStockProduct(thresholdId);
    }

    @GetMapping("/value")
    public ResponseEntity<Object> getTotalValue(){
     return getTotalValueOfAllProductService.getTotalValueOfAllProduct();
    }
}
