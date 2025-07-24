package com.example.graphql.repository;

import com.example.graphql.model.CustomerAddressDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAddressRepository extends JpaRepository<CustomerAddressDAO, Long> {

    CustomerAddressDAO findBycEmail(String cEmail);

    CustomerAddressDAO deleteBycEmail(String cEmail);

}
