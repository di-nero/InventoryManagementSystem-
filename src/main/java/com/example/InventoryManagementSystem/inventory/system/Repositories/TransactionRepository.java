package com.example.InventoryManagementSystem.inventory.system.Repositories;

import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import com.example.InventoryManagementSystem.inventory.system.Entities.Transactions;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions , Long>{
    List<Transactions> findByProductName(String productName);
}
