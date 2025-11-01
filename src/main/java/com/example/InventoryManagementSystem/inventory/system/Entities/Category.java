package com.example.InventoryManagementSystem.inventory.system.Entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import java.util.List;


@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "category name is required")
    @Length(min = 2 , max = 100 , message = "category name must be between 2 to 100 characters")
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> product;

    @NotBlank(message = "category description is required")
    @Length(max = 225 , message = "category description must be more than 225 characters")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category(String description, List<Product> product, String name, Long id) {
        this.description = description;
        this.product = product;
        this.name = name;
        this.id = id;
    }

    public Category() {
    }
}
