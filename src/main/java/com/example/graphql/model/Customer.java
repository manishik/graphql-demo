package com.example.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Setter
@Getter
@Entity
public class Customer {

    public Customer() {
    }

    public Customer(Long custid, String firstName, String middleName, String lastName, String email, Long phoneNumber, Long cellNumber, String address) {
        this.custid = custid;
        this.custFirstName = firstName;
        this.custMiddleName = middleName;
        this.custLastName = lastName;
        this.custEmail = email;
        this.custPhoneNumber = phoneNumber;
        this.custCellPhoneNumber = cellNumber;
        this.custAddress = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "custid")
    private Long custid;

    @Column(name = "custfirstname")
    private String custFirstName;

    @Column(name = "custmiddlename")
    private String custMiddleName;

    @Column(name = "custlastname")
    private String custLastName;

    @Column(name = "custemail")
    private String custEmail;

    @Column(name = "custphonenumber")
    private Long custPhoneNumber;

    @Column(name = "custcellnumber")
    private Long custCellPhoneNumber;

    @Column(name = "custaddress")
    private String custAddress;

}
