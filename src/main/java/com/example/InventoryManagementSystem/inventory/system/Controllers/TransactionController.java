package com.example.InventoryManagementSystem.inventory.system.Controllers;

import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionsDto;
import com.example.InventoryManagementSystem.inventory.system.Mapper.Mappers;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.TransactionRepository;
import com.example.InventoryManagementSystem.inventory.system.Service.ProductService.GetLowStockProductService;
import com.example.InventoryManagementSystem.inventory.system.Service.TransactionService.CreateTransactionService;
import com.example.InventoryManagementSystem.inventory.system.Service.TransactionService.GetAllTransactionService;
import com.example.InventoryManagementSystem.inventory.system.Service.TransactionService.GetTransactionByProductNameService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@Transactional
public class TransactionController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private CreateTransactionService createTransactionService;
    @Autowired
    private Mappers mappers;
    @Autowired
    private GetAllTransactionService getAllTransactionService;
    @Autowired
    private GetTransactionByProductNameService getTransactionByProductNameService;


    @PostMapping
    public Object createTransaction(@RequestBody TransactionsDto transactionsDto){
    return createTransactionService.createTransactionService(transactionsDto);
    }

    @GetMapping
    public ResponseEntity<List<TransactionsDto>> getAllTransaction(){
        return getAllTransactionService.getAllTransaction();
    }

    @GetMapping("/product/{productName}")
    public ResponseEntity<List<TransactionsDto>> getTransactionByproductName(@PathVariable String productName){
        return getTransactionByProductNameService.getProductByProductName(productName);
    }

}

