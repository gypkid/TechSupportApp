package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Type;

import java.util.List;

public interface TypeDAO {
    List<Type> findAll();
    Type findById(long id);
    void save(Type type);
    void update(Type type);
    void deleteById(long id);
}
