package com.to_do_list_api.services;

import com.to_do_list_api.entities.TaskEntity;
import com.to_do_list_api.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity save(TaskEntity task) {
        return this.taskRepository.save(task);
    }

    public List<TaskEntity> findAll() {
        return this.taskRepository.findAll();
    }

    public Optional<TaskEntity> findById(Long id) {
        return this.taskRepository.findById(id);
    }

    public TaskEntity markDone(TaskEntity task) {
        task.setDone(true);
        return this.save(task);
    }
}
