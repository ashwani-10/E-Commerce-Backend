package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.requestbody.CreateProductDTO;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public Product productMapper(CreateProductDTO productDTO, ApplicationUser user){
        Product product = new Product();
        product.setName(productDTO.getProductName());
        product.setProductCategory(productDTO.getProductCategory());
        product.setPrice(productDTO.getProductPrice());
        product.setQuantity(productDTO.getProductQuantity());
        product.setSeller(user);
        product.setQuantitySold(0);
        product.setRating(0.0);

        return product;
    }
}
