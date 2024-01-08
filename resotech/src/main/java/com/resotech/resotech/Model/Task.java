package com.resotech.resotech.Model;



import java.util.Date;

import javax.validation.constraints.NotNull;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Task name cannot be blank")
    @NotNull(message = "Task name is required")
    @Column(nullable = false)
    private String taskName;

  
   @NotBlank(message = "Task name cannot be blank")
    @NotNull(message = "Task name is required")
    @Column(nullable = false)
    private String description;

   @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Due date cannot be null")
    @Column(nullable = false)
    private Date dueDate;

    

    public Task() {
    }

    

    public Task(Long id, String taskName, String description, Date dueDate) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    

    // Getters and Setters

    // Constructors

    // Additional methods or annotations as needed
}

