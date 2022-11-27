package com.techsupport.api.DAO;

import com.techsupport.api.DAO.interfaces.NoteDAO;
import com.techsupport.api.models.Note;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class NoteDAOImpl implements NoteDAO {

    private EntityManager entityManager;

    @Autowired
    public NoteDAOImpl(EntityManager entityManager){this.entityManager = entityManager;}

    @Override
    public List<Note> findAll() {
        List<Note> notes = entityManager.createQuery("from Note", Note.class).getResultList();
        return notes;
    }

    @Override
    public Note findById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Note note = session.get(Note.class, id);
        return note;
    }

    @Override
    public void save(Note note) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(note);
    }

    @Override
    public void update(Note note) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(note);
    }

    @Override
    public void deleteById(long id) {
        Session session = entityManager.unwrap(Session.class);
        Query q = session.createQuery("DELETE FROM Note where id=:noteId");
        q.setParameter("noteId", id);
        q.executeUpdate();
    }
}
