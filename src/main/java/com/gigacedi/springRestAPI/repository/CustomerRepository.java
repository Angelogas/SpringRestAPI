package com.gigacedi.springRestAPI.repository;

import com.gigacedi.springRestAPI.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerByFirstNameAndLastName(String firstName,String lastName);
}


