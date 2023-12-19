package com.wiss.m223.controller;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Diese Klasse repräsentiert eine Anmeldeanforderung.
 */
public class SignupRequest {

    /**
     * Der Benutzername.
     */
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    /**
     * Die E-Mail-Adresse.
     */
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    /**
     * Die Rolle(n) des Benutzers.
     */
    private Set<String> role;

    /**
     * Das Passwort.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * Gibt den Benutzernamen zurück.
     *
     * @return Der Benutzername.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setzt den Benutzernamen.
     *
     * @param username Der Benutzername.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gibt die E-Mail-Adresse zurück.
     *
     * @return Die E-Mail-Adresse.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setzt die E-Mail-Adresse.
     *
     * @param email Die E-Mail-Adresse.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gibt die Rolle(n) des Benutzers zurück.
     *
     * @return Die Rolle(n) des Benutzers.
     */
    public Set<String> getRole() {
        return role;
    }

    /**
     * Setzt die Rolle(n) des Benutzers.
     *
     * @param role Die Rolle(n) des Benutzers.
     */
    public void setRole(Set<String> role) {
        this.role = role;
    }

    /**
     * Gibt das Passwort zurück.
     *
     * @return Das Passwort.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setzt das Passwort.
     *
     * @param password Das Passwort.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
