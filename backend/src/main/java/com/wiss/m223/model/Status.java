package com.wiss.m223.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Die Klasse Status repräsentiert den Status eines Tasks in der Todo-App.
 */
@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EStatus name;

    /**
     * Standardkonstruktor für die Klasse Status.
     */
    public Status() {
    }

    /**
     * Gibt die ID des Status zurück.
     * 
     * @return Die ID des Status.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID des Status.
     * 
     * @param id Die ID des Status.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gibt den Namen des Status zurück.
     * 
     * @return Der Name des Status.
     */
    public EStatus getName() {
        return name;
    }

    /**
     * Setzt den Namen des Status.
     * 
     * @param name Der Name des Status.
     */
    public void setName(EStatus name) {
        this.name = name;
    }

    /**
     * Konstruktor für die Klasse Status.
     * 
     * @param name Der Name des Status.
     */
    public Status(EStatus name) {
        this.name = name;
    }

    /**
     * Die möglichen Statuswerte für einen Task.
     */
    public enum EStatus {
        STATUS_OFFEN,
        STATUS_IN_BEARBEITUNG,
        STATUS_ABGESCHLOSSEN
    }
}
