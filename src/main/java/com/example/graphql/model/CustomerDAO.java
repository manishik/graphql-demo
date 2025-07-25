package com.example.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Customer")
public class CustomerDAO {

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
    private String cPhoneNumber;

    @Column(name = "custcellnumber")
    private String cCellPhoneNumber;

}
