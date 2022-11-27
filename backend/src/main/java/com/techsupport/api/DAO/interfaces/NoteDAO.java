package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Note;

import java.util.List;

public interface NoteDAO {
    List<Note> findAll();
    Note findById(long id);
    void save(Note note);
    void update(Note note);
    void deleteById(long id);
}
