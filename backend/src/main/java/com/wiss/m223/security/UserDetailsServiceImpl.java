package com.wiss.m223.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wiss.m223.model.Role;
import com.wiss.m223.model.User;
import com.wiss.m223.repository.UserRepository;

import jakarta.transaction.Transactional;

/**
 * Implementiert den UserDetailsService und stellt Methoden zur Authentifizierung und Autorisierung von Benutzern bereit.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    /**
     * Lädt einen Benutzer anhand seines Benutzernamens und erstellt ein UserDetailsImpl-Objekt.
     * @param username der Benutzername des Benutzers
     * @return das UserDetailsImpl-Objekt, das den Benutzer repräsentiert
     * @throws UsernameNotFoundException wenn kein Benutzer mit dem angegebenen Benutzernamen gefunden wurde
     */
    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role r : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(r.getName().toString()));
        }
        return UserDetailsImpl.build(user);
    }
}
