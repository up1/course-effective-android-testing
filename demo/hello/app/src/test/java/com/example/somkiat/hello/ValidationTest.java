package com.example.somkiat.hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    @Test
    public void with_empty_string() {
        Validation validation = new Validation();
        assertTrue(validation.isEmpty(""));
    }

    @Test
    public void with_null() {
        Validation validation = new Validation();
        assertTrue(validation.isEmpty(null));
    }

    @Test
    public void with_space() {
        Validation validation = new Validation();
        assertTrue(validation.isEmpty(" "));
    }
}