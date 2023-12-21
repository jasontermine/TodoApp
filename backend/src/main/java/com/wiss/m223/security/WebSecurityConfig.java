package com.wiss.m223.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Diese Klasse konfiguriert die Web-Sicherheit für die Anwendung.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private AuthenticationEntryPoint unauthorizedHandler;
    private final static String[] EVERYONE = { "/public", "/api/auth/**" };
    private final static String[] SECURE = { "/private/todo" };
    private final static String[] ADMIN = { "/admin/**" };
    private final static String[] ROLES = { "USER", "ADMIN" };

    /**
     * Erstellt einen AuthTokenFilter Bean.
     * @return Der erstellte AuthTokenFilter.
     */
    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    /**
     * Erstellt einen DaoAuthenticationProvider Bean.
     * @return Der erstellte DaoAuthenticationProvider.
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    /**
     * Erstellt einen AuthenticationManager Bean.
     * @param authConfig Die AuthenticationConfiguration.
     * @return Der erstellte AuthenticationManager.
     * @throws Exception Wenn ein Fehler beim Erstellen des AuthenticationManagers auftritt.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * Erstellt einen PasswordEncoder Bean.
     * @return Der erstellte PasswordEncoder.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Erstellt einen SecurityFilterChain Bean.
     * @param http Die HttpSecurity.
     * @return Der erstellte SecurityFilterChain.
     * @throws Exception Wenn ein Fehler beim Erstellen des SecurityFilterChains auftritt.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth.requestMatchers(EVERYONE).permitAll()
                        .requestMatchers(SECURE).hasAnyRole(ROLES).requestMatchers(ADMIN).hasRole("ADMIN").anyRequest().authenticated());
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticationJwtTokenFilter(),
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}