package com.shopping.shoppingbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @OneToOne
    ApplicationUser shopper;
    int totalAmount;
    int totalQuantity;


    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval = true)
    List<CartItem> cartItems;

}
