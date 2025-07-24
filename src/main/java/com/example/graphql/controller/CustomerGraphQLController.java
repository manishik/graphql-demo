package com.example.graphql.controller;

import com.example.graphql.dto.CustomerDTO;
import com.example.graphql.service.CustomerService;
import graphql.GraphQLException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Slf4j
@Controller
public class CustomerGraphQLController {

    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public List<CustomerDTO> listAllCustomers() {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();
        return customerDTOS;
    }

    @QueryMapping
    public CustomerDTO getCustomerByEmailId(@Argument String cEmail) {
        return customerService.getCustomerByEmail(cEmail);
    }

    @MutationMapping
    public CustomerDTO addCustomer(@Argument String cEmail, @Argument String cFirstName, @Argument String cMiddleName, @Argument String cLastName,
                                   @Argument String cPhoneNumber, @Argument String cCellPhoneNumber) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCEmail(cEmail);
        customerDTO.setCFirstName(cFirstName);
        customerDTO.setCMiddleName(cMiddleName);
        customerDTO.setCLastName(cLastName);
        customerDTO.setCPhoneNumber(cPhoneNumber);
        customerDTO.setCCellPhoneNumber(cCellPhoneNumber);
        return customerService.createCustomer(customerDTO);
    }

    @MutationMapping
    public CustomerDTO updateCustomerByEmail(@Argument String cEmail, @Argument String cFirstName, @Argument String cMiddleName, @Argument String cLastName,
                                             @Argument String cPhoneNumber, @Argument String cCellPhoneNumber) throws GraphQLException {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCEmail(cEmail);
        customerDTO.setCFirstName(cFirstName);
        customerDTO.setCMiddleName(cMiddleName);
        customerDTO.setCLastName(cLastName);
        customerDTO.setCPhoneNumber(cPhoneNumber);
        customerDTO.setCCellPhoneNumber(cCellPhoneNumber);
        return customerService.updateCustomerByEmail(customerDTO);
    }

    @MutationMapping
    public CustomerDTO deleteCustomerByEmail(@Argument String cEmail) {
        return customerService.deleteCustomer(cEmail);
    }
}
