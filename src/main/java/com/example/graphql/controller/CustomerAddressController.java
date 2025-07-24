package com.example.graphql.controller;

import com.example.graphql.dto.CustomerAddressDTO;
import com.example.graphql.service.CustomerAddressService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class CustomerAddressController {

    @Autowired
    private CustomerAddressService customerAddressService;

    @MutationMapping
    public CustomerAddressDTO addAddressByEmail(@Argument String cEmail, @Argument int doorNo, @Argument String street1, @Argument String street2,
                                                @Argument String area, @Argument int zipCode, @Argument String state, @Argument String country,
                                                @Argument String addressTyp, @Argument String phoneNumber, @Argument String email) {
        CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();
        customerAddressDTO.setCEmail(cEmail);
        customerAddressDTO.setDoorNo(doorNo);
        customerAddressDTO.setStreet1(street1);
        customerAddressDTO.setStreet2(street2);
        customerAddressDTO.setArea(area);
        customerAddressDTO.setZipCode(zipCode);
        customerAddressDTO.setState(state);
        customerAddressDTO.setCountry(country);
        customerAddressDTO.setAddressType(addressTyp);
        customerAddressDTO.setEmail(email);
        customerAddressDTO.setPhoneNumber(phoneNumber);

        return customerAddressService.createCustomerAddress(customerAddressDTO);
    }

    @MutationMapping
    public CustomerAddressDTO updateAddressByEmail(@Argument String cEmail, @Argument int doorNo, @Argument String street1, @Argument String street2,
                                                   @Argument String area, @Argument int zipCode, @Argument String state, @Argument String country,
                                                   @Argument String addressTyp, @Argument String phoneNumber, @Argument String email) {
        CustomerAddressDTO customerAddressDTO = new CustomerAddressDTO();
        customerAddressDTO.setCEmail(cEmail);
        customerAddressDTO.setDoorNo(doorNo);
        customerAddressDTO.setStreet1(street1);
        customerAddressDTO.setStreet2(street2);
        customerAddressDTO.setArea(area);
        customerAddressDTO.setZipCode(zipCode);
        customerAddressDTO.setState(state);
        customerAddressDTO.setCountry(country);
        customerAddressDTO.setAddressType(addressTyp);
        customerAddressDTO.setEmail(email);
        customerAddressDTO.setPhoneNumber(phoneNumber);
        return customerAddressService.updateCustomerAddressByEmail(customerAddressDTO);
    }

    @MutationMapping
    public CustomerAddressDTO deleteAddressByEmail(@Argument String cEmail) {
        return customerAddressService.deleteCustomerAddressByEmail(cEmail);
    }


}
