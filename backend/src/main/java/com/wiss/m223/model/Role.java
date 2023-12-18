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
 * Die Klasse Role repräsentiert eine Rolle in der Anwendung.
 */
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    /**
     * Standardkonstruktor für die Klasse Role.
     */
    public Role() {
    }

    /**
     * Gibt die ID der Rolle zurück.
     *
     * @return Die ID der Rolle.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setzt die ID der Rolle.
     *
     * @param id Die ID der Rolle.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gibt den Namen der Rolle zurück.
     *
     * @return Der Name der Rolle.
     */
    public ERole getName() {
        return name;
    }

    /**
     * Setzt den Namen der Rolle.
     *
     * @param name Der Name der Rolle.
     */
    public void setName(ERole name) {
        this.name = name;
    }

    /**
     * Konstruktor für die Klasse Role.
     *
     * @param name Der Name der Rolle.
     */
    public Role(ERole name) {
        this.name = name;
    }

    /**
     * Die Enumeration ERole enthält die verschiedenen Rollen.
     */
    public enum ERole {
        ROLE_USER,
        ROLE_MODERATOR,
        ROLE_ADMIN
    }
}
