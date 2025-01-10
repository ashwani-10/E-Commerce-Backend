package com.shopping.shoppingbackend.Model;

import com.shopping.shoppingbackend.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID orderId;
    int orderTotalAmount;
    String ShopperEmail;
    @Enumerated(EnumType.STRING)
    OrderStatus orderStatus;


    @OneToMany
    List<OrderItem> orderItems;
}
