package com.sda.springapporderclient.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("User not found.");
    }

    public UserNotFoundException(Long id) {
        super("Not found userId: " + id);
    }

    public UserNotFoundException(String text) {
        super("User " + text + " not found.");
    }

    public UserNotFoundException(String firstName, String lastName) {
        super("Not found user: " + firstName + " " + lastName);
    }
}
