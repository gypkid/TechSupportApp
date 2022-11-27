package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.PersonDAO;
import com.techsupport.api.errors.exceptions.PersonNotFoundExeption;
import com.techsupport.api.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonDAOImpl implements PersonDAO {

    private EntityManager entityManager;

    @Autowired
    public PersonDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Person> findAll() {
        List<Person> persons = entityManager.createQuery("from Person", Person.class).getResultList();
        return persons;
    }

    @Override
    public Person findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, id);
        if(person == null) throw new PersonNotFoundExeption("Couldn't find person with id = " + id);
        return person;
    }

    @Override
    public void save(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }

    @Override
    public void update(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }


    @Transactional
    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Person where personId=:personId");
        q.setParameter("personId", id);
        q.executeUpdate();
    }


}
