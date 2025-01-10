package com.shopping.shoppingbackend.controller;

import com.shopping.shoppingbackend.Exceptions.UserNotAllowed;
import com.shopping.shoppingbackend.Exceptions.UserNotFound;
import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.requestbody.CreateProductDTO;
import com.shopping.shoppingbackend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/createProduct")
    public ResponseEntity createProduct(@RequestBody CreateProductDTO createProductDTO, @RequestParam String sellerEmail){
        try{
            sellerService.createProduct(createProductDTO,sellerEmail);
        }catch (UserNotAllowed userNotAllowed){
            return new ResponseEntity(userNotAllowed.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (UserNotFound userNotFound){
            return new ResponseEntity(userNotFound.getMessage(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Product Added Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/sellersInventory")
    public List<Product> sellersInventory(@RequestParam String sellersEmail){
        return sellerService.sellersInventory(sellersEmail);
    }
}
