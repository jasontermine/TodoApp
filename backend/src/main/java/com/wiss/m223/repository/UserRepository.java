package com.wiss.m223.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.User;

/**
 * Das UserRepository-Interface stellt Methoden zum Zugriff auf die Benutzerdatenbank bereit.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Sucht einen Benutzer anhand seines Benutzernamens.
     * 
     * @param username der Benutzername
     * @return ein Optional, das den gefundenen Benutzer enthält
     */
    Optional<User> findByUsername(String username);

    /**
     * Überprüft, ob ein Benutzer mit dem angegebenen Benutzernamen existiert.
     * 
     * @param username der Benutzername
     * @return true, wenn ein Benutzer mit dem angegebenen Benutzernamen existiert, ansonsten false
     */
    Boolean existsByUsername(String username);

    /**
     * Überprüft, ob ein Benutzer mit der angegebenen E-Mail-Adresse existiert.
     * 
     * @param email die E-Mail-Adresse
     * @return true, wenn ein Benutzer mit der angegebenen E-Mail-Adresse existiert, ansonsten false
     */
    Boolean existsByEmail(String email);
}
