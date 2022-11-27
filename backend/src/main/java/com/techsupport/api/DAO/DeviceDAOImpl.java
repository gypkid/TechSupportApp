package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.DeviceDAO;
import com.techsupport.api.errors.exceptions.PersonNotFoundExeption;
import com.techsupport.api.models.Device;
import com.techsupport.api.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class DeviceDAOImpl implements DeviceDAO {

    private EntityManager entityManager;

    @Autowired
    public DeviceDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Device> findAll() {
        List<Device> devices = entityManager.createQuery("from Device ", Device.class).getResultList();
        return devices;
    }

    @Override
    public Device findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Device device = session.get(Device.class, id);
        return device;
    }

    @Override
    public void save(Device device) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(device);
    }

    @Override
    public void update(Device device) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(device);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Device where id=:deviceId");
        q.setParameter("deviceId", id);
        q.executeUpdate();
    }
}
