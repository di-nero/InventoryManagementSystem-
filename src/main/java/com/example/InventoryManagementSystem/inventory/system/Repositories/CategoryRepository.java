package com.example.InventoryManagementSystem.inventory.system.Repositories;

import com.example.InventoryManagementSystem.inventory.system.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {
    Optional<Category> findByName(String name);
}
