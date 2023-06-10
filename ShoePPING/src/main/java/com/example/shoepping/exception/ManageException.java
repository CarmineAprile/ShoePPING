package com.example.shoepping.exception;

public class ManageException extends  Exception{

    public ManageException(String message) {
        System.err.println(message);
    }
}
