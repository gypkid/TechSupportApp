package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.TypeDAO;
import com.techsupport.api.models.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypeController {

    private TypeDAO typeDAO;

    @Autowired
    private TypeController(TypeDAO typeDAO){this.typeDAO = typeDAO;}

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public List<Type> findAll(){ return typeDAO.findAll(); }

    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    public Type findById(@PathVariable("id") long id){
        return typeDAO.findById(id);
    }

    @RequestMapping(value = "/types", method = RequestMethod.POST)
    public Type create(@RequestBody Type type) {
        typeDAO.save(type);
        return type;
    }

    @RequestMapping(value = "/types", method = RequestMethod.PUT)
    public Type update(@RequestBody Type type){
        typeDAO.save(type);
        return type;
    }

    @RequestMapping(value = "/types/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        typeDAO.deleteById(id);
    }

}
