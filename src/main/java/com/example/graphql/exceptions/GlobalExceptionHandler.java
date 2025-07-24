package com.example.graphql.exceptions;

import graphql.GraphQLError;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handles CustomerNotFoundException
    @GraphQlExceptionHandler
    public GraphQLError handleCustomerNotAvailableException(CustomerNotFoundException customerNotFoundException) {
        return GraphQLError.newError().message(customerNotFoundException.getMessage()).build();
    }

    // Handles CustomerAlreadyExistsException
    @GraphQlExceptionHandler
    public GraphQLError handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException) {
        return GraphQLError.newError().message(customerAlreadyExistsException.getMessage()).build();
    }

}
