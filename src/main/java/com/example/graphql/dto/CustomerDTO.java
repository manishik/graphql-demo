package com.example.graphql.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String cEmail;
    private String cFirstName;
    private String cMiddleName;
    private String cLastName;
    private String cPhoneNumber;
    private String cCellPhoneNumber;
    private CustomerAddressDTO cAddress;

}
