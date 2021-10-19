package com.gigacedi.springRestAPI.dao;

import java.util.List;

import com.gigacedi.springRestAPI.repository.CustomerRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gigacedi.springRestAPI.entity.Customer;

@Repository
public class CustomerDAOImpl {

    // need to inject the session factory
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomers() {

//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        // create a query  ... sort by last name
//        Query<Customer> theQuery =
//                currentSession.createQuery("from Customer order by lastName",
//                        Customer.class);
//
//        // execute query and get result list
//        List<Customer> customers = theQuery.getResultList();
//
//        // return the results

        List<Customer> customers= customerRepository.findAll();

        return customers;
    }
//
//    @Override
    public void saveCustomer(Customer theCustomer) {

        // get current hibernate session
        customerRepository.save(theCustomer);

        // save/upate the customer ... finally LOL

    }
//
//    @Override
    public Customer getCustomer(int theId) {

//        // get the current hibernate session
//        Session currentSession = sessionFactory.getCurrentSession();
//
//        // now retrieve/read from database using the primary key
//        Customer theCustomer = currentSession.get(Customer.class, theId);

        Customer theCustomer = customerRepository.getById(theId);
//
        return theCustomer;
    }

    public void deleteCustomer(int theId) {

        customerRepository.deleteById(theId);
    }

}











