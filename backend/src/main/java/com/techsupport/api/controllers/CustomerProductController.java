package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.CustomerProductDAO;
import com.techsupport.api.models.CustomerProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerProductController {

    private CustomerProductDAO customerProductDAO;

    @Autowired
    public CustomerProductController(CustomerProductDAO customerProductDAO){
        this.customerProductDAO = customerProductDAO;
    }

    @RequestMapping(value = "/customerproducts", method = RequestMethod.GET)
    public List<CustomerProduct> findAll(){
        return customerProductDAO.findAll();
    }

    @RequestMapping(value = "/customerproducts/{id}", method = RequestMethod.GET)
    public CustomerProduct findById(@PathVariable("id") long id){
        return customerProductDAO.findById(id);
    }

    @RequestMapping(value = "/customerproducts", method = RequestMethod.POST)
    public CustomerProduct create(@RequestBody CustomerProduct customerProduct){
        customerProductDAO.save(customerProduct);
        return customerProduct;
    }

    @RequestMapping(value = "/customerproducts", method = RequestMethod.PUT)
    public CustomerProduct update(@RequestBody CustomerProduct customerProduct){
        customerProductDAO.update(customerProduct);
        return customerProduct;
    }

    @RequestMapping(value = "/customerproducts/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        customerProductDAO.deleteById(id);
    }

}
