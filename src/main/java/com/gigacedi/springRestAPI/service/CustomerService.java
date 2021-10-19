package com.gigacedi.springRestAPI.service;

import java.util.List;

import com.gigacedi.springRestAPI.entity.Customer;

public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomer(int theId);

    public void saveCustomer(Customer theCustomer);

    public void deleteCustomer(int theId);

}
