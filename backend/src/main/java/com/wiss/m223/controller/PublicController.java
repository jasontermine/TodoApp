package com.wiss.m223.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PublicController {
	
	/**
	 * Ruft eine Liste von Begrüssungen ab.
	 *
	 * @return ResponseEntity, das eine Liste von Zeichenketten enthält, die Begrüssungen repräsentieren.
	 */
	@GetMapping("/public")
	public ResponseEntity<List<String>> getGreeting() {
		return ResponseEntity.ok(List.of("Chrigu zipfu", "Michi zipfu", "Phippu zipfu"));
	} 
	
}
