package com.gigacedi.springRestAPI.dao;

import java.util.List;
import java.util.Optional;

import com.gigacedi.springRestAPI.ExceptionHandler.CustomerAlreadyExistException;
import com.gigacedi.springRestAPI.ExceptionHandler.CustomerAllException;
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

        try {

            Customer customer = findCustomer(theCustomer);

            if (customer == null) {
                theCustomer.setId(0);
                customerRepository.save(theCustomer);
            } else {
                throw new CustomerAlreadyExistException();
            }
            } catch (CustomerAlreadyExistException exc) {
                throw new CustomerAllException();

            } catch (RuntimeException e) {
                throw new CustomerAllException(new IllegalArgumentException());
            }
    }

    public void update(Customer theCustomer) {

        Customer customer = findCustomer(theCustomer);
        int id = customer.getId();
        if (id != theCustomer.getId()) {
            throw new CustomerAllException(customer.getFirstName(),customer.getFirstName());
        }
        try {
            customer.setId(id);
            customerRepository.save(customer);
        }catch (NullPointerException e) {
            throw new CustomerAllException(new NullPointerException());
        }catch (RuntimeException e) {
            throw new CustomerAllException(new IllegalArgumentException());
        }
    }

    public void deleteCustomer(Customer theCustomer) {

        try {
            Customer customer = findCustomer(theCustomer);
            customerRepository.delete(customer);

        } catch (NullPointerException exc) {
            throw new CustomerAllException(exc);
        }
        catch (RuntimeException e) {
            throw new CustomerAllException(new IllegalArgumentException());
        }
    }

    public void deleteCustomerById(int id) {

        try {
        Optional<Customer> customer = customerRepository.findById(id);
            customerRepository.delete(customer.get());
        } catch (NullPointerException exc) {
            throw new CustomerAllException(exc);
        }

    }

    public Customer findCustomer(Customer customer) {
        return customerRepository.findCustomerByFirstNameAndLastName(customer.getFirstName(),customer.getLastName());
    }
}











