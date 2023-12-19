package com.wiss.m223.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.Status;
import com.wiss.m223.model.Status.EStatus;
    
/**
 * Das StatusRepository-Interface stellt Methoden zum Zugriff auf die Datenbanktabelle "status" bereit.
 */
@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    /**
     * Sucht einen Status anhand des Namens.
     * 
     * @param name der Name des Status
     * @return ein Optional-Objekt, das den gefundenen Status enthält, falls vorhanden
     */
    Optional<Status> findByName(EStatus name);
}
