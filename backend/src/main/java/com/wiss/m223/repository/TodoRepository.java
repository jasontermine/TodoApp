package com.wiss.m223.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.Todo;
import com.wiss.m223.model.Status.EStatus;

/**
 * Das TodoRepository-Interface stellt Methoden zum Zugriff auf die Datenbank für die Todo-Entität bereit.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    /**
     * Sucht ein Todo anhand des Namens.
     * 
     * @param name der Name des Todos
     * @return ein Optional, das das gefundene Todo enthält, falls vorhanden
     */
    Optional<Todo> findByName(String name);

    /**
     * Überprüft, ob ein Todo mit dem angegebenen Status existiert.
     * 
     * @param status der Status des Todos
     * @return true, wenn ein Todo mit dem angegebenen Status existiert, ansonsten false
     */
    Boolean existsByStatus(EStatus status);

    // Boolean existsByStatus(Status status);
}
