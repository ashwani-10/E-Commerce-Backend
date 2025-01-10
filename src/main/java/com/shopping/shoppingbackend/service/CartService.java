package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Exceptions.UserNotAllowed;
import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.Model.Cart;
import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.repository.CartRepo;
import com.shopping.shoppingbackend.repository.ProductRepo;
import com.shopping.shoppingbackend.requestbody.SingleProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    UserUtils userUtils;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CartRepo cartRepo;

//    public String addtoCart(SingleProductDTO singleProductDTO, String shopperEmail) {
//        ApplicationUser user = userUtils.verifyEmail(shopperEmail);
//        userUtils.isShopper(user);
//
//        Cart thisUserCart = getUsersCart(shopperEmail);
////        List<Product> productsList = thisUserCart.getProducts();
//
//        Product product = productRepo.findByName(singleProductDTO.getProductName());
//        if(!productsList.contains(product)) {
//            productsList.add(product);
//        }
//
//        int totalAmount = thisUserCart.getTotalAmount();
//        int totalQuantity = thisUserCart.getTotalQuantity();
//        for(Product item : productsList){
//            totalAmount += item.getPrice()*singleProductDTO.getProductQuantity();
//            totalQuantity += singleProductDTO.getProductQuantity();
//        }
//        thisUserCart.setTotalAmount(totalAmount);
//        thisUserCart.setTotalQuantity(totalQuantity);
//        thisUserCart.setProducts(productsList);
//        cartRepo.save(thisUserCart);
//
//        return "Product Added to Cart";
//    }

    public Cart getUsersCart(String shopperEmail) {
        ApplicationUser user = userUtils.verifyEmail(shopperEmail);
        userUtils.isShopper(user);

        Cart userCart = getUsersCart(shopperEmail);
        if(userCart.equals(null)){
            throw new UserNotAllowed("No cart available ");
        }

        return userCart;
    }
}
