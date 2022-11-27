package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.CustomerProductDAO;
import com.techsupport.api.models.CustomerProduct;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CustomerProductDAOImpl implements CustomerProductDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<CustomerProduct> findAll() {
        List<CustomerProduct> customerProducts =
                entityManager.createQuery("from CustomerProduct", CustomerProduct.class).getResultList();
        return customerProducts;
    }

    @Override
    public CustomerProduct findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        CustomerProduct customerProduct = session.get(CustomerProduct.class, id);
        return customerProduct;
    }

    @Override
    public void save(CustomerProduct customerProduct) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customerProduct);
    }

    @Override
    public void update(CustomerProduct customerProduct) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(customerProduct);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM CustomerProduct where id=:customerProductId");
        q.setParameter("customerProductId", id);
        q.executeUpdate();
    }
}
