package com.gigacedi.springRestAPI.dao;

import java.util.List;
import java.util.Optional;

import com.gigacedi.springRestAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gigacedi.springRestAPI.entity.Customer;

@Repository
public class CustomerDAOImpl{

    // need to inject the session factory
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers() {

//        Optional<Customer> result = customerRepository.findById(theId);
//        Customer customer = null;
//        if (result.isPresent()) {
//            customer = result.get();
//        } else {
//            throw new RuntimeException("Did not find customer id - "+ theId);
//        }
//        return customer;

        List<Customer> customers= customerRepository.findAll();

        return customers;
    }

    public Customer getCustomer(int theId) {

        Customer theCustomer = customerRepository.getById(theId);

        return theCustomer;
    }

    public void saveCustomer(Customer theCustomer) {

        Optional<Customer> result = Optional.ofNullable(customerRepository.findCustomerByFirstNameAndLastName(theCustomer.getFirstName(),
                theCustomer.getLastName()));
        if (result.isEmpty()) {
            customerRepository.save(theCustomer);
        }else {
            throw new RuntimeException("Customer already exist. Cannot duplicate");
        }
    }

    public void update(Customer theCustomer) {

        try {
             customerRepository.findCustomerByFirstNameAndLastName(theCustomer.getFirstName(), theCustomer.getLastName());
            customerRepository.save(theCustomer);
        } catch (RuntimeException exc) {
            throw new RuntimeException("Customer not found...");
        }

    }

    public void deleteCustomer(int theId) {

        customerRepository.deleteById(theId);
    }

}











