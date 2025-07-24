package com.example.graphql.dto;

import lombok.Data;

@Data
public class CustomerAddressDTO {

    private Integer doorNo;
    private String street1;
    private String street2;
    private String area;
    private Integer zipCode;
    private String state;
    private String country;
    private String addressType;
    private String phoneNumber;
    private String email;
    private String cEmail;

}
