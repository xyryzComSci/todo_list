package com.example.todoapp.entity; // Adjust package to your project's structure

import lombok.Data; // Lombok annotation for getters, setters, equals, hashCode, toString
import lombok.NoArgsConstructor; // Lombok annotation for no-arg constructor
import lombok.AllArgsConstructor; // Lombok annotation for all-args constructor

import javax.persistence.*; // JPA annotations (or jakarta.persistence for newer versions)
import java.time.LocalDate; // For dueDate
import java.time.LocalDateTime; // For createdAt, updatedAt

@Entity // Marks this class as a JPA entity, mapped to a database table
@Table(name = "tasks") // Specifies the exact table name in the database
@Data // Lombok: Generates getters, setters, equals, hashCode, toString methods
@NoArgsConstructor // Lombok: Generates a no-argument constructor
@AllArgsConstructor // Lombok: Generates a constructor with all fields

public class Task {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments in the database
    private Long id; // Use Long for id to match BIGINT in MySQL

    @Column(nullable = false, length = 255) // Maps to VARCHAR(255) NOT NULL
    private String title;

    @Column(columnDefinition = "TEXT") // Maps to TEXT type in MySQL
    private String description;

    @Column(name = "due_date") // Maps to the 'due_date' column
    private LocalDate dueDate; // Use LocalDate for MySQL DATE type

    @Enumerated(EnumType.STRING) // Stores the enum value as a String in the database ('HIGH', 'MEDIUM', 'LOW')
    @Column(nullable = false, columnDefinition = "ENUM('high', 'mid', 'low') DEFAULT 'mid'")
    private Priority priority; // Custom Enum for task priority

    @Column(name = "is_completed", nullable = false) // Maps to 'is_completed' column, NOT NULL
    private boolean isCompleted = false; // Default value in Java, matches DB default

    @Column(name = "created_at", updatable = false) // Maps to 'created_at', prevents updates via JPA
    private LocalDateTime createdAt;

    @Column(name = "updated_at") // Maps to 'updated_at'
    private LocalDateTime updatedAt;

    @PrePersist // JPA lifecycle callback: Executed before the entity is first persisted (inserted)
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate // JPA lifecycle callback: Executed before the entity is updated
    protected void voidOnUpdate() { // Changed method name to avoid conflict and clearly define it's for update
        this.updatedAt = LocalDateTime.now();
    }
}
