package com.example.mobileapp.customer;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException (String message){
        super(message);
    }
}
