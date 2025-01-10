package com.shopping.shoppingbackend.requestbody;

import lombok.Data;

@Data
public class SingleProductDTO {
    String productName;
    int productQuantity;
}
