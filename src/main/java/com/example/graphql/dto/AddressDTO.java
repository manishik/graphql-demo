package com.example.graphql.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Long doorNo;
    private String street1;
    private String street2;
    private String area;
    private int zipCode;
    private String state;
    private String country;
    private String cEmail;

}
