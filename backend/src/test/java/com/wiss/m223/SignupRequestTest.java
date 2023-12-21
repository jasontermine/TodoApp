package com.wiss.m223;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.wiss.m223.controller.SignupRequest;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

/**
 * Diese Klasse enthält Tests für die Validierung der SignupRequest-Klasse.
 */
public class SignupRequestTest {

    private final Validator validator;

    /**
     * Konstruktor, der den Validator initialisiert.
     */
    public SignupRequestTest() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    /**
     * Testet eine gültige SignupRequest.
     */
    @Test
    public void testValidSignupRequest() {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setUsername("Christoph");
        signupRequest.setEmail("Christoph@example.com");
        signupRequest.setPassword("zipfu123");

        Set<ConstraintViolation<SignupRequest>> violations = validator.validate(signupRequest);
        Assertions.assertTrue(violations.isEmpty());
    }
}