package com.example.InventoryManagementSystem.inventory.system.Service.TransactionService;

import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionsDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllTransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private Mappers mappers;


    public ResponseEntity<List<TransactionsDto>> getAllTransaction(){
        return ResponseEntity
                .ok( transactionRepository
                .findAll()
                .stream()
                .map(transactions -> mappers.toTransactionDto(transactions))
                .toList());
    }
}
