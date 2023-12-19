/**
 * Diese Klasse repräsentiert die Hauptanwendungsklasse für die M223-Anwendung.
 * Sie ist dafür verantwortlich, die Spring Boot-Anwendung zu starten und CORS (Cross-Origin Resource Sharing) zu konfigurieren.
 */
package com.wiss.m223;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class M223Application {

	public static void main(String[] args) {
		SpringApplication.run(M223Application.class, args);
	}
	
	/**
	 * Konfiguriert CORS (Cross-Origin Resource Sharing) für die Anwendung.
	 * Diese Methode erlaubt Anfragen von den angegebenen Ursprüngen auf die angegebenen Endpunkte zuzugreifen.
	 * @return Die konfigurierte WebMvcConfigurer-Instanz.
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/public").allowedOrigins("http://localhost:5173");
				registry.addMapping("/private/**").allowedOrigins("http://localhost:5173");
				registry.addMapping("/admin/**").allowedOrigins("http://localhost:5173");
				registry.addMapping("/api/auth/**").allowedOrigins("http://localhost:5173");
			}
		};

	}
	

}
