package com.gigacedi.springRestAPI.service;

import java.util.List;

import com.gigacedi.springRestAPI.Model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    public List<Customer> getCustomers();
    public Customer getCustomer(int theId);

    public void saveCustomer(Customer theCustomer);
    void updateCustomer (Customer theCustomer);

    public void deleteCustomer(Customer customer);

    void deleteById(int id);
}
