package com.wiss.m223.controller;
/**
 * Diese Klasse repräsentiert eine Login-Anfrage.
 */
public class LoginRequest {
    private String username;
    private String password;

    /**
     * Gibt den Benutzernamen zurück.
     *
     * @return Der Benutzername
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setzt den Benutzernamen.
     *
     * @param username Der Benutzername
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gibt das Passwort zurück.
     *
     * @return Das Passwort
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setzt das Passwort.
     *
     * @param password Das Passwort
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Standardkonstruktor für LoginRequest.
     */
    public LoginRequest() {
    }

    /**
     * Konstruktor für LoginRequest mit Benutzernamen und Passwort.
     *
     * @param username Der Benutzername
     * @param password Das Passwort
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
