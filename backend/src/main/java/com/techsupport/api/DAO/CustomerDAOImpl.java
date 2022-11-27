package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.CustomerDAO;
import com.techsupport.api.models.Customer;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers = entityManager.createQuery("from Customer", Customer.class).getResultList();
        return customers;
    }

    @Override
    public Customer findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    public void update(Customer customer) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Customer WHERE id=:customerId");
        q.setParameter("customerId",id);
        q.executeUpdate();
    }
}
