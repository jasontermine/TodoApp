package com.wiss.m223.model;

import com.wiss.m223.model.Status.EStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;
    
    @NotBlank
    private String message;

    public Todo(int id, String name, String message, Status status) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.status = status;
    }

    public Todo(String name, String message, Status status) {
        this.name = name;
        this.message = message;
        this.status = status;
    }
    
    public Todo(String name, String message) {
        this.name = name;
        this.message = message;
        this.status = new Status(EStatus.STATUS_OFFEN);
    }

    public Todo() {}

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
