package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Customer;

import java.util.List;

public interface CustomerDAO {
    List<Customer> findAll();
    Customer findById(long id);
    void save(Customer customer);
    void update(Customer customer);
    void deleteById(long id);
}
