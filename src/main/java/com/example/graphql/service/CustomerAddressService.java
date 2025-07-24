package com.example.graphql.service;

import com.example.graphql.dto.CustomerAddressDTO;
import com.example.graphql.exceptions.CustomerNotFoundException;
import com.example.graphql.model.CustomerAddressDAO;
import com.example.graphql.repository.CustomerAddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CustomerAddressService {

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerAddressDTO getCustomerAddressByEmail(String customerEmail) {
        log.info("Inside Service: getCustomerAddressByEmail");
        CustomerAddressDAO customerAddressDAO = customerAddressRepository.findBycEmail(customerEmail);
        if (customerAddressDAO != null) {
            return modelMapper.map(customerAddressDAO, CustomerAddressDTO.class);
        }
        throw new CustomerNotFoundException("Customer Email ID not found");
    }

    @Transactional
    public CustomerAddressDTO createCustomerAddress(CustomerAddressDTO customerAddressDTO) {
        CustomerAddressDAO customerAddressDAO = modelMapper.map(customerAddressDTO, CustomerAddressDAO.class);
        CustomerAddressDAO customerAddressDAO1 = customerAddressRepository.findBycEmail(customerAddressDAO.getCEmail());
        if (customerAddressDAO1 != null) {
            CustomerAddressDAO customerAddressDAO2 = customerAddressRepository.saveAndFlush(customerAddressDAO);
            return modelMapper.map(customerAddressDAO2, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

    @Transactional()
    public CustomerAddressDTO updateCustomerAddressByEmail(CustomerAddressDTO customerAddressDTO) {
        // Check if user exists
        CustomerAddressDAO customerAddressDAO = modelMapper.map(customerAddressDTO, CustomerAddressDAO.class);
        CustomerAddressDAO customerAddressDAO1 = customerAddressRepository.findBycEmail(customerAddressDAO.getCEmail());
        if (customerAddressDAO1 != null) {
            CustomerAddressDAO customerAddressDAO2 = customerAddressRepository.save(customerAddressDAO);
            return modelMapper.map(customerAddressDAO2, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

    @Transactional
    public CustomerAddressDTO deleteCustomerAddressByEmail(String customerEmail) {
        CustomerAddressDAO customerAddressDAO = customerAddressRepository.findBycEmail(customerEmail);
        if (customerAddressDAO != null) {
            CustomerAddressDAO customerAddressDAO1 = customerAddressRepository.deleteBycEmail(customerEmail);
            return modelMapper.map(customerAddressDAO1, CustomerAddressDTO.class);
        } else {
            throw new CustomerNotFoundException("Customer Email ID not found");
        }
    }

}
