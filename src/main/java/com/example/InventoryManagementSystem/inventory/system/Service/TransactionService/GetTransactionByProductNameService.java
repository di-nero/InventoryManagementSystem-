package com.example.InventoryManagementSystem.inventory.system.Service.TransactionService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionsDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTransactionByProductNameService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Mappers mappers;

    public ResponseEntity<List<TransactionsDto>> getProductByProductName(String productName){
            var result = transactionRepository.findByProductName(productName).stream().map(transactions -> mappers.toTransactionDto(transactions)).toList();
            if (result.isEmpty())
                throw new RuntimeException("there are no matching product name");
            return ResponseEntity.ok(result);
    }
}
