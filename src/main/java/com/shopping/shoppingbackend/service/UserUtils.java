package com.shopping.shoppingbackend.service;

import com.shopping.shoppingbackend.Exceptions.UserNotAllowed;
import com.shopping.shoppingbackend.Exceptions.WrongCredentialsEsception;
import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.enums.UserType;
import com.shopping.shoppingbackend.repository.ApplicationUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUtils {
    @Autowired
    ApplicationUserRepo applicationUserRepo;
    public ApplicationUser verifyEmail(String email) {
        ApplicationUser user = applicationUserRepo.findByEmail(email);
        if (user == null) {
            throw new WrongCredentialsEsception(String.format("User with email %s does not exists", email));
        } else {
            return user;
        }
    }
    public void isSeller (ApplicationUser user){
        UserType userType = user.getUserType();
        if(userType != UserType.SELLER)
            throw new UserNotAllowed(String.format("User with this email %s not allowed to create product",user.getEmail()));
    }

    public void isShopper (ApplicationUser user){
        UserType userType = user.getUserType();
        if(userType != UserType.SHOPPER)
            throw new UserNotAllowed(String.format("User with this email %s not allowed to create product",user.getEmail()));
    }
}
