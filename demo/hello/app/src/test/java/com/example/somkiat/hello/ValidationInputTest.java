package com.example.somkiat.hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationInputTest {

    @Test
    public void null_should_be_empty() {
        assertTrue( ValidationInput.isEmpty(null) );
    }

    @Test
    public void emptystring_should_be_empty() {
        assertTrue( ValidationInput.isEmpty("") );
    }

    @Test
    public void one_space_should_be_empty() {
        assertTrue( ValidationInput.isEmpty(" ") );
    }
}