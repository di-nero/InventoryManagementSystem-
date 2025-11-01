package com.example.InventoryManagementSystem.inventory.system.DTOs;

import com.example.InventoryManagementSystem.inventory.system.Entities.Product;
import com.example.InventoryManagementSystem.inventory.system.Entities.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TransactionsDto {
    private String productName;
    private Long productId;
    private int quantity;
    private TransactionType type;
    private String remarks;

    public TransactionsDto(Long productId, String remarks, TransactionType type, int quantity, String productName) {
        this.productId = productId;
        this.remarks = remarks;
        this.type = type;
        this.quantity = quantity;
        this.productName = productName;
    }

    public TransactionsDto() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
