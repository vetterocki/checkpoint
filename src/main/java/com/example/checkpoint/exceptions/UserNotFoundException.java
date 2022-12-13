package com.example.checkpoint.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("Could not find user by username %s", username));
    }
}
