package com.techsupport.api.DAO.interfaces;
import com.techsupport.api.models.Person;
import java.util.List;

public interface PersonDAO {

    List<Person> findAll();
    Person findById(long id);
    void save(Person person);
    void update(Person person);
    void deleteById(long id);
}
