package com.example.graphql.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private Long custId;
    private String custFirstName;
    private String custLastName;
    private String custEmail;

}
