package com.shopping.shoppingbackend.controller;

import com.shopping.shoppingbackend.Exceptions.WrongCredentialsEsception;
import com.shopping.shoppingbackend.Model.ApplicationUser;
import com.shopping.shoppingbackend.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserRegistration {

    @Autowired
    UserRegistrationService userRegistration;

    @PostMapping("/registration")
    public ResponseEntity userRegistration(@RequestBody ApplicationUser user){
        userRegistration.userRegistration(user);
        return new ResponseEntity<>("Registration Successful",HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity userLogin(@RequestHeader String Credentials){
        String[] details = Credentials.split(":");
        String email = details[0];
        String password = details[1];
        try{
            userRegistration.userLogin(email,password);
            return new ResponseEntity<>("Login Successfully", HttpStatus.OK);
        }catch (WrongCredentialsEsception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

}
