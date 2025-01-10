package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public List<Product> searchProduct(String productName){
        List<Product> products = new ArrayList<>();
        products.add(productRepo.findByName(productName));
        return products;
    }

//    public List<Product> searchProductByCategory(String productCategory){
//
//    }

}
