package com.shopping.shoppingbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @ManyToOne
    @JoinColumn(name = "cart_id, nullable = false")
    Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id, nullable false")
    Product product;

    int quantity;
    int price;

}
