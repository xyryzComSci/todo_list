package com.example.todoapp.service; // Adjust package

import com.example.todoapp.entity.Task; // Import your Task entity
import com.example.todoapp.repository.TaskRepository; // Import your TaskRepository
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring Service component
public class TaskService {

    @Autowired // Automatically injects an instance of TaskRepository
    private TaskRepository taskRepository;

    // Retrieve all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // Retrieve a single task by ID
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Create a new task
    public Task createTask(Task task) {
        // You can add validation or additional business logic here before saving
        return taskRepository.save(task);
    }

    // Update an existing task
    public Task updateTask(Long id, Task taskDetails) {
        // Find the existing task by ID
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id)); // Handle not found case

        // Update its properties with the new details
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setDueDate(taskDetails.getDueDate());
        task.setPriority(taskDetails.getPriority());
        task.setCompleted(taskDetails.isCompleted());
        // createdAt and updatedAt are handled by @PrePersist/@PreUpdate and DB

        // Save the updated task
        return taskRepository.save(task);
    }

    // Delete a task by ID
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
