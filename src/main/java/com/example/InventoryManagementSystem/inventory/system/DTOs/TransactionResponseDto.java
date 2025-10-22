package com.example.InventoryManagementSystem.inventory.system.DTOs;

import com.example.InventoryManagementSystem.inventory.system.Entities.TransactionType;

import java.time.LocalDateTime;

public class TransactionResponseDto {
    public Long id;
    public String productName;
    public int quantityChanged;
    public TransactionType type;
    public LocalDateTime timeStamp;
    public String remarks;

    public TransactionResponseDto(Long id, LocalDateTime timeStamp, TransactionType type, int quantityChanged, String productName, String remarks) {
        this.id = id;
        this.timeStamp = timeStamp;
        this.type = type;
        this.quantityChanged = quantityChanged;
        this.productName = productName;
        this.remarks = remarks;
    }

    public TransactionResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getQuantityChanged() {
        return quantityChanged;
    }

    public void setQuantityChanged(int quantityChanged) {
        this.quantityChanged = quantityChanged;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemarks(){
        return remarks;
    }

    public void setRemarks(String remarks){
        this.remarks = remarks;
    }
}
