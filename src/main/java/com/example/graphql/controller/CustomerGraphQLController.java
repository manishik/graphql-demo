package com.example.graphql.controller;

import com.example.graphql.dto.CustomerDTO;
import com.example.graphql.model.CustomerDAO;
import com.example.graphql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class CustomerGraphQLController {

    @Autowired
    private CustomerService customerService;

    @QueryMapping
    public List<CustomerDTO> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public CustomerDTO getCustomerById(@Argument Long custId) {
        return customerService.getCustomer(custId);
    }

    @MutationMapping
    public CustomerDTO addCustomer(@Argument Long custId, @Argument String custFirstName, @Argument String custLastName, @Argument String custEmail) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustId(custId);
        customerDTO.setCustFirstName(custFirstName);
        customerDTO.setCustLastName(custLastName);
        customerDTO.setCustEmail(custEmail);

        return customerService.createCustomer(customerDTO);
    }

    @MutationMapping
    public CustomerDTO updateCustomer(@Argument Long custId, @Argument String custFirstName, @Argument String custLastName, @Argument String custEmail) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustId(custId);
        customerDTO.setCustFirstName(custFirstName);
        customerDTO.setCustLastName(custLastName);
        customerDTO.setCustEmail(custEmail);
        return customerService.updateCustomer(customerDTO);
    }

    @MutationMapping
    public String deleteCustomer(@Argument Long custId) {
        return customerService.deleteCustomer(custId);
    }
}
