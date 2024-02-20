package com.example.mobileapp.product;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="brand_name")
    private String brandName;
    @Column(name="model_name")
    private String modelName;
    @Column(name="price")
    private Double price;
    @Column(name="color")
    private String color;

    public Product() {
        super();
    }
    public Product(Integer id, String brandName, String modelName, Double price, String color) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.price = price;
        this.color = color;
        this.id=id;
    }

}
