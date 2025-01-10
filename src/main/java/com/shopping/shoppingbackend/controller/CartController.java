package com.shopping.shoppingbackend.controller;

import com.shopping.shoppingbackend.Model.Cart;
import com.shopping.shoppingbackend.requestbody.SingleProductDTO;
import com.shopping.shoppingbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
//    public String Cart(@RequestBody SingleProductDTO singleProductDTO, @RequestParam String shopperEmail){
//        return cartService.addtoCart(singleProductDTO,shopperEmail);
//    }

    @GetMapping("/showCart")
    public Cart getUsersCart(@RequestParam String shopperEmail){
        return cartService.getUsersCart(shopperEmail);
    }
}
