package com.wiss.m223;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.wiss.m223.model.Role;
import com.wiss.m223.model.User;
import com.wiss.m223.model.Role.ERole;
import com.wiss.m223.repository.UserRepository;
import com.wiss.m223.security.UserDetailsImpl;
import com.wiss.m223.security.UserDetailsServiceImpl;

import static org.mockito.Mockito.*;

public class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDetailsServiceImpl userDetailsService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Testet die Methode loadUserByUsername der UserDetailsServiceImpl-Klasse.
     */
    @Test
    public void testLoadUserByUsername() {
        // Arrange
        String username = "testUser";
        User user = new User();
        user.setUsername(username);
        Role role = new Role();
        role.setName(ERole.ROLE_USER);

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // Act
        UserDetailsImpl userDetails = userDetailsService.loadUserByUsername(username);

        // Assert
        Assertions.assertEquals(username, userDetails.getUsername());

        verify(userRepository, times(1)).findByUsername(username);
    }

    /**
     * Testet das Verhalten der Methode loadUserByUsername, wenn der Benutzer nicht gefunden wird.
     */
    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Arrange
        String username = "nonExistingUser";

        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // Act & Assert
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername(username);
        });

        verify(userRepository, times(1)).findByUsername(username);
    }
}