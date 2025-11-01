package com.example.InventoryManagementSystem.inventory.system.Service.TransactionService;


import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionResponseDto;
import com.example.InventoryManagementSystem.inventory.system.DTOs.TransactionsDto;
import com.example.InventoryManagementSystem.inventory.system.Entities.TransactionType;
import com.example.InventoryManagementSystem.inventory.system.Entities.Transactions;
import com.example.InventoryManagementSystem.inventory.system.Repositories.ProductRepository;
import com.example.InventoryManagementSystem.inventory.system.Repositories.TransactionRepository;
import com.example.InventoryManagementSystem.inventory.system.Response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateTransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private ProductRepository productRepository;


    public ResponseEntity<Object> createTransactionService(TransactionsDto transactionsDto){
        var product = productRepository.findById(transactionsDto.getProductId()).orElseThrow(()-> new RuntimeException("product not found"));

        if (transactionsDto.getType()== TransactionType.INCREASE){
            product.setQuantity(transactionsDto.getQuantity() + product.getQuantity());
        } else if (transactionsDto.getType()== TransactionType.DECREASE) {
            if (transactionsDto.getQuantity() > product.getQuantity())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ApiResponse.responseBuilder(false , "only " + product.getQuantity() + " of this product remaining" , null));
            product.setQuantity(product.getQuantity() - transactionsDto.getQuantity());
        }
        productRepository.save(product);

        Transactions transactions = new Transactions();
        transactions.setProduct(product);
        transactions.setType(transactionsDto.getType());
        transactions.setRemarks(transactionsDto.getRemarks());
        transactions.setQuantity(transactionsDto.getQuantity());
        transactionRepository.save(transactions);

        TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
        transactionResponseDto.setId(product.getId());
        transactionResponseDto.setType(transactions.getType());
        transactionResponseDto.setProductName(product.getName());
        transactionResponseDto.setTimeStamp(transactions.getTimeStamp());
        transactionResponseDto.setQuantityChanged(transactions.getQuantity());
        transactionResponseDto.setRemarks(transactions.getRemarks());

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.responseBuilder(true , "transaction recorded successfully" , transactionResponseDto));
    }
}
