package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Exceptions.WrongCredentialsEsception;
import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.Model.Cart;
import com.shopping.shoppingbackend.Model.Product;
import com.shopping.shoppingbackend.enums.UserType;
import com.shopping.shoppingbackend.repository.ApplicationUserRepo;
import com.shopping.shoppingbackend.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserRegistrationService {

    @Autowired
    ApplicationUserRepo applicationUserRepo;

    @Autowired
    CartRepo cartRepo;

    public void userRegistration(ApplicationUser user) {
        user.setUserType(user.getUserType());
//        if(user.getUserType().equals(UserType.SHOPPER)){
//            Cart cart = new Cart();
//            cart.setShopper(user);
//            List<Product> productList = new ArrayList<>();
//            cart.setProducts(productList);
//            cart.setTotalAmount(0);
//            cart.setTotalQuantity(0);
//            cartRepo.save(cart);
//        }
        applicationUserRepo.save(user);
    }

    public boolean userLogin(String email,String password){
        ApplicationUser user = applicationUserRepo.findByEmail(email);
        if(user == null){
            throw new WrongCredentialsEsception(String.format("Invalid Email or Password"));
        }

        String actualPassword = user.getPassword();
        if(actualPassword.equals(password)){
            return true;
        }else {
            throw new WrongCredentialsEsception(String.format("Invalid Email or Password"));
        }
    }
}
