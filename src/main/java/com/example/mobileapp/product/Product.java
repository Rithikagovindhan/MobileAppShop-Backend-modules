package com.example.mobileapp.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotBlank(message = "Brand name is required")
    @Column(name="brand_name")
    private String brandName;

    @NotBlank(message = "Model name is required")
    @Column(name="model_name")
    private String modelName;

    @NotNull(message = " Price is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Column(name="price")
    private Double price;

    @NotBlank(message = "Color is required")
    @Column(name="color")
    private String color;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity must be a positive number")
    @Column(name="QUANTITY")
    private Integer quantity;

    public Product() {
        super();
    }

    public Product(Integer id, String brandName, String modelName, Double price, String color, Integer quantity) {
        this.id = id;
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
// Constructors, getters, and setters omitted for brevity
}
