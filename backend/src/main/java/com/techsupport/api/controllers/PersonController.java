package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.PersonDAO;
import com.techsupport.api.models.Person;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class PersonController {

    private PersonDAO personDao;

    public PersonController(PersonDAO personDao){
        this.personDao = personDao;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public List<Person> findAll(){
        return personDao.findAll();
    }

    @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
    public Person findById(@PathVariable("id") long personId) {
        return personDao.findById(personId);
    }

    @RequestMapping(value = "/persons", method = RequestMethod.POST)
    public Person create(@RequestBody Person person){
        personDao.save(person);
        return person;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.PUT)
    public Person update(@RequestBody Person person){
        personDao.update(person);
        return person;
    }

    @RequestMapping(value = "/persons/{personId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("personId") long personId) {
        personDao.deleteById(personId);
    }

}
