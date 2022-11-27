package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.TaskDAO;
import com.techsupport.api.DAO.interfaces.TypeDAO;
import com.techsupport.api.models.Task;
import com.techsupport.api.models.Type;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class TypeDAOImpl implements TypeDAO {

    private EntityManager entityManager;

    @Autowired
    public TypeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Type> findAll() {
        List<Type> types = entityManager.createQuery("from Type", Type.class).getResultList();
        return types;
    }

    @Override
    public Type findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Type type = session.get(Type.class, id);
        return type;
    }

    @Override
    public void save(Type type) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(type);
    }

    @Override
    public void update(Type type) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(type);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Type WHERE id=:typeId");
        q.setParameter("typeId", id);
        q.executeUpdate();
    }
}
