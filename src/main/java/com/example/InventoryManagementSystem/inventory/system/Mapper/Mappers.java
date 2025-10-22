package com.example.InventoryManagementSystem.inventory.system.Mapper;

import com.example.InventoryManagementSystem.inventory.system.DTOs.ProductDto;
import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionsDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import com.example.InventoryManagementSystem.inventory.system.Entities.Transactions;
import com.example.InventoryManagementSystem.inventory.system.Repositories.CategoryRepository;
import org.springframework.stereotype.Component;
import com.example.InventoryManagementSystem.inventory.system.DTOs.CategoryDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.Category;

@Component
public class Mappers {

    private final CategoryRepository categoryRepository;

    public Mappers(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(category.getName(), category.getDescription());
    }

    public Category toCategoryEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        return category;
    }


    public ProductDto toProductDto(Product product){
        return new ProductDto(
                product.getName() ,
                product.getPrice(),
                product.getQuantity() ,
                product.getCategory().getName());
    }

    public Product toProductEntity(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setQuantity(productDto.getQuantity());

        Category category = categoryRepository.findByName(productDto.getCategoryName()).orElseThrow(() -> new RuntimeException("category not found"));

        product.setCategory(category);

        return product;

    }

    public TransactionsDto toTransactionDto(Transactions transactions){
        return new TransactionsDto(transactions.getProduct().getId() , transactions.getRemarks() , transactions.getType() , transactions.getQuantity() , transactions.getProduct().getName());
    }
}
