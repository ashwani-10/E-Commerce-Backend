package com.shopping.shoppingbackend.Exceptions;

public class WrongCredentialsEsception extends RuntimeException{
    public WrongCredentialsEsception(String message){
        super(message);
    }
}
