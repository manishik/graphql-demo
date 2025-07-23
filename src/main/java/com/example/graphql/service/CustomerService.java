package com.example.graphql.service;

import com.example.graphql.dto.CustomerDTO;
import com.example.graphql.model.CustomerDAO;
import com.example.graphql.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerDAO> customersDAO = customerRepository.findAll();
        log.info("Size of customersDAO : {}", customersDAO.size());
        return Arrays.asList(modelMapper.map(customersDAO, CustomerDTO[].class));
    }

    public CustomerDTO getCustomer(Long customerId) {
        CustomerDTO customerDTO = modelMapper.map(customerRepository.findById(customerId).get(), CustomerDTO.class);
        return customerDTO;
    }

    @Transactional
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        CustomerDAO customerDAO = modelMapper.map(customerDTO, CustomerDAO.class);
        log.info("getCustId : {}", customerDAO.getCustId());
        log.info("getCustLastName : {}", customerDAO.getCustLastName());
        log.info("getCustFirstName : {}", customerDAO.getCustFirstName());
        log.info("getCustEmail : {}", customerDAO.getCustEmail());
        CustomerDAO customerDAO1 = customerRepository.saveAndFlush(customerDAO);
        //customerRepository.flush();
        return modelMapper.map(customerDAO1, CustomerDTO.class);
    }

    @Transactional ()
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        // Check if user exists
        Long custId = customerDTO.getCustId();
        CustomerDTO customerDTO1 = modelMapper.map(customerRepository.findById(custId).get(), CustomerDTO.class);
        CustomerDAO customerDAO = modelMapper.map(customerDTO, CustomerDAO.class);
        CustomerDAO customerDAO1 = customerRepository.save(customerDAO);
        return modelMapper.map(customerDAO1, CustomerDTO.class);
    }

    @Transactional
    public String deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
        return customerId + " deleted successfully";
    }
}
