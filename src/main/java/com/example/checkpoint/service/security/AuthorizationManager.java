package com.example.checkpoint.service.security;

import com.example.checkpoint.model.menus.CheckPointMenu;

public interface AuthorizationManager<T, R> {
    R authorize(T source);
}
