package com.example.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "customeraddress")
public class CustomerAddressDAO {

    @Id
    @Column(name = "custemail")
    private String cEmail;

    @Column(name = "doorno")
    private Integer doorNo;

    @Column(name = "street1")
    private String street1;

    @Column(name = "street2")
    private String street2;

    @Column(name = "area")
    private String area;

    @Column(name = "zipcode")
    private Integer zipCode;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "addresstype")
    private String addressType;

    @Column(name = "phonenumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
