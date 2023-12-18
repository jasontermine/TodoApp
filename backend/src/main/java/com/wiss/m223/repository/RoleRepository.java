package com.wiss.m223.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wiss.m223.model.Role;
import com.wiss.m223.model.Role.ERole;
    
/**
 * Das RoleRepository-Interface stellt Methoden zum Zugriff auf die Datenbanktabelle "role" bereit.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Sucht eine Rolle anhand des Namens.
     * 
     * @param name der Name der Rolle
     * @return eine optionale Rolle, die den angegebenen Namen hat
     */
    Optional<Role> findByName(ERole name);
}
