package com.example.graphql.controller;

import com.example.graphql.model.Customer;
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
    public List<Customer> listAllCustomers() {
        return customerService.getAllCustomers();
    }

    @QueryMapping
    public Customer getCustomerById(@Argument Long id) {
        return customerService.getCustomer(id);
    }

    @MutationMapping
    public Customer addCustomer(@Argument Long custId, @Argument String custFirstName, @Argument String custLastName, @Argument String custEmail) {
        Customer customer = new Customer();
        //customer.setCustid(custId);
        customer.setCustFirstName(custFirstName);
        customer.setCustLastName(custLastName);
        customer.setCustEmail(custEmail);
        return customerService.createCustomer(customer);
    }
}
