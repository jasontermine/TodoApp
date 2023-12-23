package com.wiss.m223.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiss.m223.model.Todo;
import com.wiss.m223.repository.TodoRepository;

import jakarta.transaction.Transactional;

/**
 * Der AdminController ist für die Verwaltung der Todos zuständig.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	TodoRepository todoRepository;
	
	/**
	 * Gibt alle Todos zurück.
	 * 
	 * @return Die Liste der Todos
	 */
	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getTodo() {
		List<Todo> todos = todoRepository.findAll();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	/**
	 * Erstellt ein neues Todo.
	 * 
	 * @param todo Das zu erstellende Todo
	 * @return Das erstellte Todo
	 */
	@Transactional
	@PostMapping("/todos/create")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {

		Todo _todo = todoRepository.save(todo);
		return new ResponseEntity<>(_todo, HttpStatus.CREATED);
	}
	
	/**
	 * Löscht ein Todo anhand der ID.
	 * 
	 * @param id Die ID des zu löschenden Todos
	 * @return Der Status der Anfrage
	 */
	@DeleteMapping("/todos/delete/{id}")
	public ResponseEntity<HttpStatus> deleteTodoById(@PathVariable("id") long id) {
		try {
			todoRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
