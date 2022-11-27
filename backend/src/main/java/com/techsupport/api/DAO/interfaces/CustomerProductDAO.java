package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.CustomerProduct;

import java.util.List;

public interface CustomerProductDAO {
    List<CustomerProduct> findAll();
    CustomerProduct findById(long id);
    void save(CustomerProduct customerProduct);
    void update(CustomerProduct customerProduct);
    void deleteById(long id);
}
