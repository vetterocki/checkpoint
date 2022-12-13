package com.example.checkpoint.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(String username) {
        super(String.format("Wrong password for user %s", username));
    }
}
