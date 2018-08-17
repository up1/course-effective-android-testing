package com.example.somkiat.hello;

class ValidationInput {
    public static boolean isEmpty(String input) {
        return input == null || input.trim().length() == 0;
    }
}
