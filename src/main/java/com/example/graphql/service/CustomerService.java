package com.example.graphql.service;

import com.example.graphql.model.Customer;
import com.example.graphql.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Transactional
    public Customer updateCustomer(Customer customer) {
        // Check if user exists
        Optional<Customer> existingCust = repository.findById(customer.getCustid());

        if (existingCust.isPresent()) {
            Customer customer1 = existingCust.get();
            if (customer1.getCustLastName() != null) {
                customer.setCustLastName(customer1.getCustLastName());
            }
            if (customer1.getCustFirstName() != null) {
                customer.setCustFirstName(customer1.getCustFirstName());
            }
            if (customer1.getCustEmail()!= null) {
                customer.setCustEmail(customer1.getCustEmail());
            }
            return repository.save(customer);
        } else{
            return customer;
        }
    }

    @Transactional
    public String deleteCustomer(Long custId) {
        repository.deleteById(custId);
        return custId + " deleted successfully";
    }
}
