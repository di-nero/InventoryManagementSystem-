package com.example.InventoryManagementSystem.inventory.system.Repositories;

import com.example.InventoryManagementSystem.inventory.system.Entities.Category;
import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    //for validation in delete mapping
    boolean existsByCategory(Category category);
    List<Product> findByQuantityLessThanEqual(int thresholdId);
    @Query("SELECT SUM(p.price * p.quantity) FROM Product p")
    Double getTotalProductValue();
}
