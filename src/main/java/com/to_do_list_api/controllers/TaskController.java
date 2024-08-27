package com.to_do_list_api.controllers;

import com.to_do_list_api.entities.TaskEntity;
import com.to_do_list_api.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public ResponseEntity<TaskEntity> save(@RequestBody @Valid TaskEntity task) {
        TaskEntity newTask = this.taskService.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(newTask);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TaskEntity>> findAll() {
        return ResponseEntity.ok(this.taskService.findAll());
    }

    @PostMapping("/mark-done/{id}")
    public ResponseEntity<?> markDone(@PathVariable Long id) {
        Optional<TaskEntity> task = this.taskService.findById(id);
        if (task.isEmpty()) return ResponseEntity.notFound().build();
        TaskEntity doneTask = this.taskService.markDone(task.get());
        return ResponseEntity.ok(doneTask);
    }
}
