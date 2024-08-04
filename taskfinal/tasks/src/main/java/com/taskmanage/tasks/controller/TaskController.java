package com.taskmanage.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taskmanage.tasks.model.Task;
import com.taskmanage.tasks.model.User;
import com.taskmanage.tasks.service.TaskService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// @RestController
// @RequestMapping("/api/tasks")
// public class TaskController {
//     @Autowired
//     private TaskService taskService;

//     @GetMapping
//     public List<Task> getAllTasks() {
//         return taskService.getAllTasks();
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//         Optional<Task> task = taskService.getTaskById(id);
//         return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     @PostMapping
//     public Task createTask(@RequestBody Task task) {
//         return taskService.saveTask(task);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
//         try {
//             Task updatedTask = taskService.updateTask(id, taskDetails);
//             return ResponseEntity.ok(updatedTask);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//         taskService.deleteTask(id);
//         return ResponseEntity.noContent().build();
//     }

//     @GetMapping("/project/{projectId}")
//     public List<Task> getTasksByProjectId(@PathVariable Long projectId) {
//         return taskService.getTasksByProjectId(projectId);
//     }

//     @GetMapping("/assignedTo/{userId}")
//     public List<Task> getTasksByAssignedTo(@PathVariable Long userId) {
//         return taskService.getTasksByAssignedTo(userId);
//     }

//     @PostMapping("/assign/{taskId}")
//     public ResponseEntity<Task> assignTaskToTeamMember(@PathVariable Long taskId, @RequestParam Long userId) {
//         try {
//             Task updatedTask = taskService.assignTaskToTeamMember(taskId, userId);
//             return ResponseEntity.ok(updatedTask);
//         } catch (RuntimeException e) {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    // @PutMapping("/{id}")
    // public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails)
    // {
    // return taskService.updateTask(id, taskDetails);
    // }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

    // @PutMapping("/{taskId}/assign")
    // public Task assignTask(@PathVariable Long taskId, @RequestBody User user) {
    // return taskService.assignTask(taskId, user);
    // }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        Task updatedTask = taskService.updateTask(id, updates);
        return ResponseEntity.ok(updatedTask);
    }
}
