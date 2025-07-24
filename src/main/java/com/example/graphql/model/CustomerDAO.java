package com.example.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "Customer")
public class CustomerDAO {

    public CustomerDAO() {
    }

    @Id
    @Column(name = "custemail")
    private String cEmail;

    @Column(name = "custfirstname")
    private String cFirstName;

    @Column(name = "custmiddlename")
    private String cMiddleName;

    @Column(name = "custlastname")
    private String cLastName;

    @Column(name = "custphonenumber")
    private Long cPhoneNumber;

    @Column(name = "custcellnumber")
    private Long cCellPhoneNumber;

    @Column(name = "custaddress")
    private String cAddress;

}
