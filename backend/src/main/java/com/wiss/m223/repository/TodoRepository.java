package com.wiss.m223.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.wiss.m223.model.Todo;
import com.wiss.m223.model.Status.EStatus;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Optional<Todo> findByName(String name);

    Boolean existsByStatus(EStatus name);

    // Boolean existsByStatus(Status status);
}
