package com.example.InventoryManagementSystem.inventory.system.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "product name is required")
    @Size(min = 2 , max = 100 , message = "product name must be between 2 and 100 characters")
    @Column(unique = true , nullable = false)
    private String name;

    @NotNull(message = "category is required")
    @ManyToOne
    @JsonBackReference
    private Category category;

    @Column(nullable = false , columnDefinition = "int default 0")
    @Min(value = 0 , message = "quantity cannot be negative")
    private Integer quantity;

    @DecimalMin(value = "0.0" , inclusive = false , message = "price must be grater than 0")
    private Double price;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference //this fix returning infinite json as output of an end point
    private List<Transactions> transactions;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Product(Long id, LocalDateTime createdAt, Double price, Integer quantity, Category category, String name) {
        this.id = id;
        this.createdAt = createdAt;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.name = name;
    }

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = (quantity == null) ? 0 : quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
