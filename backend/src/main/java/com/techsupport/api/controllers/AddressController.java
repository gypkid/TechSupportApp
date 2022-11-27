package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.AddressDAO;
import com.techsupport.api.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    private AddressDAO addressDAO;

    @Autowired
    public AddressController(AddressDAO addressDAO) { this.addressDAO = addressDAO; }

    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public List<Address> findAll() { return addressDAO.findAll(); }

    @RequestMapping(value = "/addresses/{id}", method = RequestMethod.GET)
    public Address findById(@PathVariable("id") long id){
        return addressDAO.findById(id);
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.POST)
    public Address create(@RequestBody Address address){
        addressDAO.save(address);
        return address;
    }

    @RequestMapping(value = "/addresses", method = RequestMethod.PUT)
    public Address update(@RequestBody Address address){
        addressDAO.update(address);
        return address;
    }

    @RequestMapping(value = "/addresses/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        addressDAO.deleteById(id);
    }

}
