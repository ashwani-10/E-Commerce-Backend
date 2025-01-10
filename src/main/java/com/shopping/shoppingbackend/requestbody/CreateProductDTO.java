package com.shopping.shoppingbackend.requestbody;

import lombok.Data;

@Data
public class CreateProductDTO {
    String productName;
    String productCategory;
    int productPrice;
    int productQuantity;
}
