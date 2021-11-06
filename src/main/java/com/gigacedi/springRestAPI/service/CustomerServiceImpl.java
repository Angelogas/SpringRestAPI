package com.gigacedi.springRestAPI.service;

import java.util.List;
import java.util.Optional;

import com.gigacedi.springRestAPI.dao.CustomerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gigacedi.springRestAPI.dao.CustomerDAO;
import com.gigacedi.springRestAPI.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    // need to inject customer dao
    @Autowired
    private CustomerDAOImpl customerDAOImpl;

    @Override
    public List<Customer> getCustomers() {
        return customerDAOImpl.getCustomers();
    }

    @Override
    public Customer getCustomer(int theId) {
        return customerDAOImpl.getCustomer(theId);
    }



    @Override
    public void saveCustomer(Customer theCustomer) {

        customerDAOImpl.saveCustomer(theCustomer);
    }

    public void updateCustomer(Customer theCustomer) {
        customerDAOImpl.update(theCustomer);
    }

    @Override
    public void deleteCustomer(Customer customer) {

        customerDAOImpl.deleteCustomer(customer);
    }

    @Override
    public void deleteById(int id) {
        customerDAOImpl.deleteCustomerById(id);
    }

}





