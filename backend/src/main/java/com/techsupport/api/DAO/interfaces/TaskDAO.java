package com.techsupport.api.DAO.interfaces;

import com.techsupport.api.models.Task;

import java.util.List;

public interface TaskDAO {

    List<Task> findAll();
    Task findById(long id);
    void save(Task task);
    void update(Task task);
    void deleteById(long id);
}
