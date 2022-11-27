package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.NoteDAO;
import com.techsupport.api.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    private NoteDAO noteDAO;

    @Autowired
    public NoteController(NoteDAO noteDAO){this.noteDAO = noteDAO;}

    @RequestMapping(value = "/notes", method = RequestMethod.GET)
    public List<Note> findAll(){ return noteDAO.findAll();}

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.GET)
    public Note findById(@PathVariable("id") long id){
        return noteDAO.findById(id);
    }

    @RequestMapping(value = "/notes", method = RequestMethod.POST)
    public Note create(@RequestBody Note note){
        noteDAO.save(note);
        return note;
    }

    @RequestMapping(value = "/notes", method = RequestMethod.PUT)
    public Note update(@RequestBody Note note){
        noteDAO.update(note);
        return note;
    }

    @RequestMapping(value = "/notes/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        noteDAO.deleteById(id);
    }

}
