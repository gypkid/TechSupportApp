package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.TaskDAO;
import com.techsupport.api.models.Task;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class TaskDAOImpl implements TaskDAO {

    private EntityManager entityManager;

    @Autowired
    public TaskDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = entityManager.createQuery("from Task", Task.class).getResultList();
        return tasks;
    }

    @Override
    public Task findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Task task = session.get(Task.class, id);
        return task;
    }

    @Override
    public void save(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(task);
    }

    @Override
    public void update(Task task) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(task);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Task WHERE id=:taksId");
        q.setParameter("taksId", id);
        q.executeUpdate();
    }
}
