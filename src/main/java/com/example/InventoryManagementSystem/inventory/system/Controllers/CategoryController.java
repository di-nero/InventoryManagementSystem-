package com.example.InventoryManagementSystem.inventory.system.Controllers;

import com.example.InventoryManagementSystem.inventory.system.DTOs.CategoryDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Service.CategoryService.CreateCategoryService;
import com.example.InventoryManagementSystem.inventory.system.Service.CategoryService.GetCategoryByIdService;
import com.example.InventoryManagementSystem.inventory.system.Service.CategoryService.GetCategoryService;
import com.example.InventoryManagementSystem.inventory.system.Service.CategoryService.UpdateCategoryService;
import com.example.InventoryManagementSystem.inventory.system.Service.ProductService.DeleteProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private Mappers mappers;
    @Autowired
    private GetCategoryService getCategoryService;
    @Autowired
    private GetCategoryByIdService getCategoryByIdService;
    @Autowired
    private CreateCategoryService createCategoryService;
    @Autowired
    private UpdateCategoryService updateCategoryService;
    @Autowired
    private DeleteProductService deleteProductService;



    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
       return getCategoryService.getCategory();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> GetACategory(@PathVariable Long id) {
      return getCategoryByIdService.getCategoryById(id);
    }

    @PostMapping
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto) {
      return createCategoryService.createCategory(categoryDto);
    }


    @PutMapping(value = "/{id}" , consumes = "application/json",  produces = "application/json")
    public ResponseEntity<Object> updateCategory(@PathVariable Long id , @RequestBody CategoryDto categoryDto){
      return updateCategoryService.updateCategory(id , categoryDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCategory(@PathVariable Long id){
    return deleteProductService.deleteProduct(id);
    }
}
