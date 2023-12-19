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

/**
 * Die Klasse Todo repräsentiert eine Aufgabe in der Anwendung.
 */
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

    /**
     * Erstellt eine neue Instanz der Klasse Todo mit angegebener ID, Name, Nachricht und Status.
     * 
     * @param id Die ID der Aufgabe.
     * @param name Der Name der Aufgabe.
     * @param message Die Nachricht der Aufgabe.
     * @param status Der Status der Aufgabe.
     */
    public Todo(int id, String name, String message, Status status) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.status = status;
    }

    /**
     * Erstellt eine neue Instanz der Klasse Todo mit angegebenem Name, Nachricht und Status.
     * 
     * @param name Der Name der Aufgabe.
     * @param message Die Nachricht der Aufgabe.
     * @param status Der Status der Aufgabe.
     */
    public Todo(String name, String message, Status status) {
        this.name = name;
        this.message = message;
        this.status = status;
    }
    
    /**
     * Erstellt eine neue Instanz der Klasse Todo mit angegebenem Name und Nachricht.
     * Der Status wird auf "Offen" gesetzt.
     * 
     * @param name Der Name der Aufgabe.
     * @param message Die Nachricht der Aufgabe.
     */
    public Todo(String name, String message) {
        this.name = name;
        this.message = message;
        this.status = new Status(EStatus.STATUS_OFFEN);
    }

    /**
     * Erstellt eine neue Instanz der Klasse Todo.
     */
    public Todo() {}

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    /**
     * Gibt die ID der Aufgabe zurück.
     * 
     * @return Die ID der Aufgabe.
     */
    public int getId() {
        return id;
    }

    /**
     * Setzt die ID der Aufgabe.
     * 
     * @param id Die ID der Aufgabe.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gibt den Namen der Aufgabe zurück.
     * 
     * @return Der Name der Aufgabe.
     */
    public String getName() {
        return name;
    }

    /**
     * Setzt den Namen der Aufgabe.
     * 
     * @param name Der Name der Aufgabe.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gibt die Nachricht der Aufgabe zurück.
     * 
     * @return Die Nachricht der Aufgabe.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setzt die Nachricht der Aufgabe.
     * 
     * @param message Die Nachricht der Aufgabe.
     */
    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Gibt den Status der Aufgabe zurück.
     * 
     * @return Der Status der Aufgabe.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setzt den Status der Aufgabe.
     * 
     * @param status Der Status der Aufgabe.
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
