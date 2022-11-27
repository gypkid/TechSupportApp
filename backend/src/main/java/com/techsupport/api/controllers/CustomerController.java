package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.CustomerDAO;
import com.techsupport.api.models.Customer;
import org.apache.catalina.util.CustomObjectInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    private CustomerDAO customerDAO;

    @Autowired
    private CustomerController(CustomerDAO customerDAO){this.customerDAO = customerDAO;}

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<Customer> findAll(){ return customerDAO.findAll();}

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.POST)
    public Customer findById(@PathVariable("id") long id){
        return customerDAO.findById(id);
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer){
        customerDAO.save(customer);
        return customer;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer){
        customerDAO.update(customer);
        return customer;
    }

    @RequestMapping(value = "/customers/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        customerDAO.deleteById(id);
    }

}
