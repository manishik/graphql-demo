package com.example.graphql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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

    /*public CustomerDAO(Long custid, String firstName, String middleName, String lastName,
                       String email, Long phoneNumber, Long cellNumber, String address) {
        this.custid = custid;
        this.custFirstName = firstName;
        this.custMiddleName = middleName;
        this.custLastName = lastName;
        this.custEmail = email;
        this.custPhoneNumber = phoneNumber;
        this.custCellPhoneNumber = cellNumber;
        this.custAddress = address;
    }*/

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    //@SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq", allocationSize = 1)
    @Column(name = "custid")
    private Long custId;

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
