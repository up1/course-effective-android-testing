package com.example.somkiat.hello;

public class Validation {

    public boolean isEmpty(String input) {
        return input == null ||
                input.trim().length() == 0;
    }

}

