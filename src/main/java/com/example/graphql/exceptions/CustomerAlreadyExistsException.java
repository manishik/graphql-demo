package com.example.graphql.exceptions;

public class CustomerAlreadyExistsException extends RuntimeException  {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
