package com.wiss.m223.controller;

/**
 * Eine Klasse, die eine Nachricht als Antwort enthält.
 */
public class MessageResponse {

    private String message;

    /**
     * Konstruktor für die MessageResponse-Klasse.
     * @param message Die Nachricht, die in der Antwort enthalten sein soll.
     */
    public MessageResponse(String messsage) {
        this.message = messsage;
    }

    /**
     * Gibt die Nachricht zurück.
     * @return Die Nachricht.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setzt die Nachricht.
     * @param message Die Nachricht, die gesetzt werden soll.
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
