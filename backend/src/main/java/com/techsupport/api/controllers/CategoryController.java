package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.CategoryDAO;
import com.techsupport.api.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private CategoryDAO categoryDAO;

    @Autowired
    public CategoryController(CategoryDAO categoryDAO){this.categoryDAO = categoryDAO;}

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> findAll(){ return categoryDAO.findAll();}

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable("id") long id){
        return categoryDAO.findById(id);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public Category create(@RequestBody Category category){
        categoryDAO.save(category);
        return category;
    }

    @RequestMapping(value = "/categories", method = RequestMethod.PUT)
    public Category update(@RequestBody Category category){
        categoryDAO.update(category);
        return category;
    }

    @RequestMapping(value = "/categories/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id){
        categoryDAO.deleteById(id);
    }

}
