package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.AddressDAO;
import com.techsupport.api.models.Address;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class AddressDAOImpl implements AddressDAO {

    private EntityManager entityManager;

    @Autowired
    public AddressDAOImpl(EntityManager entityManager) {this.entityManager = entityManager;}

    @Override
    public List<Address> findAll() {
        List<Address> addresses = entityManager.createQuery("from Address", Address.class).getResultList();
        return addresses;
    }

    @Override
    public Address findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Address address = session.get(Address.class, id);
        return address;
    }

    @Override
    public void save(Address address) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(address);
    }

    @Override
    public void update(Address address) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(address);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Address where id=:addressId");
        q.setParameter("addressId", id);
        q.executeUpdate();
    }
}
