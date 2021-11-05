package com.gigacedi.springRestAPI.rest;

import com.gigacedi.springRestAPI.ExceptionHandler.CustomerNotFoundException;
import com.gigacedi.springRestAPI.entity.Customer;
import com.gigacedi.springRestAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @GetMapping ("/customers")
    public List<Customer> getCustomers() {
        return  customerService.getCustomers();
    }

    @GetMapping ("/customers/{customerId}")
    public Customer getCustomer (@PathVariable int customerId) {
        Customer theCustomer = null;
        if (customerId ==0 || customerId >= customerService.getCustomers().size()) {
            throw new CustomerNotFoundException("Customer id not found - "+ (customerId));
        } else {
        theCustomer = customerService.getCustomer(customerId);
        }
        return theCustomer;
    }

    @PostMapping ("/customers/save")
    public Customer addCustomer (@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping ("customers/update")
    public Customer updateCustomer (@RequestBody Customer theCustomer) {
        customerService.updateCustomer (theCustomer);
        return theCustomer;
    }

    @DeleteMapping ("customers/{customerId}")
    public String deleteCustomer (@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
        return "Deleted customer id " + customerId;
    }
}
