package com.example.todoapp.controller; // Adjust package

import com.example.todoapp.entity.Task; // Import your Task entity
import com.example.todoapp.service.TaskService; // Import your TaskService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; // For HTTP status codes
import org.springframework.http.ResponseEntity; // For building HTTP responses
import org.springframework.web.bind.annotation.*; // REST annotations

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/tasks") // Base URL path for all endpoints in this controller
@CrossOrigin(origins = "http://localhost:5173") // Crucial for allowing your React app (running on a different port) to access these endpoints
public class TaskController {

    @Autowired // Injects an instance of TaskService
    private TaskService taskService;

    // GET /api/tasks - Retrieve all tasks
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // GET /api/tasks/{id} - Retrieve a single task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        // Use ResponseEntity to return HTTP status codes
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok) // If task found, return 200 OK with task
                .orElse(ResponseEntity.notFound().build()); // If not found, return 404 Not Found
    }

    // POST /api/tasks - Create a new task
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Returns HTTP 201 Created status
    public Task createTask(@RequestBody Task task) { // @RequestBody maps JSON request body to Task object
        return taskService.createTask(task);
    }

    // PUT /api/tasks/{id} - Update an existing task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        try {
            Task updatedTask = taskService.updateTask(id, taskDetails);
            return ResponseEntity.ok(updatedTask); // Return 200 OK with updated task
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build(); // Return 404 Not Found if task not found
        }
    }

    // DELETE /api/tasks/{id} - Delete a task
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Returns HTTP 204 No Content status on successful deletion
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
