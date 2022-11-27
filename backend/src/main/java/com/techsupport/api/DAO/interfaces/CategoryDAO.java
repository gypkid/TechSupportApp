package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    Category findById(long id);
    void save(Category category);
    void update(Category category);
    void deleteById(long id);
}


