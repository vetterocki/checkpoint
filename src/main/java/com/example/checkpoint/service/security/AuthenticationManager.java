package com.example.checkpoint.service.security;

public interface AuthenticationManager<T> {
    T authenticate(String username, String password);
}
