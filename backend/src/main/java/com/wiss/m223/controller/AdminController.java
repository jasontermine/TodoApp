package com.wiss.m223.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
	
	@GetMapping("/admin")
	public ResponseEntity<String> getGreeting() {
		return ResponseEntity.ok("Hello Admin");
	} 
	
}
