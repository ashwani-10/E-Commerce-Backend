package com.shopping.shoppingbackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID orderItemId;

    @ManyToOne
    @JoinColumn(name = "order_id") // This links the OrderItem to the UserOrder
    UserOrder userOrder;

    @ManyToOne
    Product product; // Product being ordered

    int quantity;
    int price;

}
