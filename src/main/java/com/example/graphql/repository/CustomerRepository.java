package com.example.graphql.repository;

import com.example.graphql.model.CustomerDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDAO, Long> {

    CustomerDAO findBycEmail(String cEmail);

    CustomerDAO deleteBycEmail(String cEmail);
}
