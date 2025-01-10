package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.repository.ProductRepo;
import com.shopping.shoppingbackend.requestbody.CreateProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {
    @Autowired
    UserUtils userUtils;
    @Autowired
    Mapper mapper;
    @Autowired
    ProductRepo productRepo;

    public void createProduct(CreateProductDTO productDTO, String sellerEmail) {
        ApplicationUser user = userUtils.verifyEmail(sellerEmail);
        userUtils.isSeller(user);

        Product product = mapper.productMapper(productDTO,user);
        productRepo.save(product);
    }

    public List<Product> sellersInventory(String sellersEmail) {
        ApplicationUser user = userUtils.verifyEmail(sellersEmail);
        userUtils.isSeller(user);
        return productRepo.findAll();
    }
}
