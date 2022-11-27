package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Address;

import java.util.List;

public interface AddressDAO {
    List<Address> findAll();
    Address findById(long id);
    void save(Address address);
    void update(Address address);
    void deleteById(long id);
}
