package com.techsupport.api.controllers;

import com.techsupport.api.DAO.interfaces.TaskDAO;
import com.techsupport.api.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private TaskDAO taskDAO;

    @Autowired
    public TaskController (TaskDAO taskDAO){this.taskDAO = taskDAO;}

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<Task> findAll(){ return taskDAO.findAll(); }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public Task findById(@PathVariable("id") long id) {
        return taskDAO.findById(id);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public Task create(@RequestBody Task task){
        taskDAO.save(task);
        return task;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public Task update(@RequestBody Task task){
        taskDAO.update(task);
        return task;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") long id){
        taskDAO.deleteById(id);
    }

}
