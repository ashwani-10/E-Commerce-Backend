package com.shopping.shoppingbackend.Exceptions;

public class UserNotAllowed extends RuntimeException{
    public UserNotAllowed(String message){
        super(message);
    }
}
