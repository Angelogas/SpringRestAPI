package com.gigacedi.springRestAPI.service;

import java.util.List;

import com.gigacedi.springRestAPI.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomer(int theId);

    public void saveCustomer(Customer theCustomer);
    void updateCustomer (Customer theCustomer);

    public void deleteCustomer(int theId);

}
