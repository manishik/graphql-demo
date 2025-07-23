package com.example.graphql.service;

import com.example.graphql.model.Customer;
import com.example.graphql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomer(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }
}
