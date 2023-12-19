package com.wiss.m223.controller;

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
	public ResponseEntity<String> getGreeting() {
		return ResponseEntity.ok("Hi Sven :)");
	} 
	
}
