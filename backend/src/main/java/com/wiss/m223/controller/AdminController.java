package com.wiss.m223.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiss.m223.model.Todo;
import com.wiss.m223.repository.TodoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private TodoRepository todoRepository;
	
	@GetMapping("/todos")
	public ResponseEntity<List<Todo>> getTodo() {
		List<Todo> todos = todoRepository.findAll();
		return new ResponseEntity<>(todos, HttpStatus.OK);
	}

	@PostMapping("/todos")
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {

		Todo _todo = todoRepository.save(todo);
		return new ResponseEntity<>(_todo, HttpStatus.CREATED);
	}
	
}
