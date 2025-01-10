package com.shopping.shoppingbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;


@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(unique = true)
    String name;
    String productCategory;
    int price;
    int quantity;
    int quantitySold;
    Double rating;
    @ManyToOne
    ApplicationUser seller;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<CartItem> cartItems; // Reverse mapping to CartItem

}
