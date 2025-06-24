package com.example.todoapp.repository; // Adjust package

import com.example.todoapp.entity.Task; // Import your Task entity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Marks this interface as a Spring Data JPA repository
// JpaRepository<Entity_Type, ID_Type> provides common CRUD methods
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Spring Data JPA automatically provides:
    // save(Task), findById(Long), findAll(), deleteById(Long), etc.

    // You can add custom query methods by following Spring Data JPA naming conventions, e.g.:
    // List<Task> findByIsCompletedFalseOrderByDueDateAsc();
}
