package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.CategoryDAO;
import com.techsupport.api.models.Category;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CategoryDAOImpl implements CategoryDAO {

    private EntityManager entityManager;

    @Autowired
    public CategoryDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Category> findAll() {
        List<Category> categories = entityManager.createQuery("from Category ", Category.class).getResultList();
        return categories;
    }

    @Override
    public Category findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Category category = session.get(Category.class, id);
        return category;
    }

    @Override
    public void save(Category category) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(category);
    }

    @Override
    public void update(Category category) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(category);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Category WHERE id=:categoryId");
        q.setParameter("categoryId", id);
        q.executeUpdate();
    }
}
