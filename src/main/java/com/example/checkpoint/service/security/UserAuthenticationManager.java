package com.example.checkpoint.service.security;

import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.User;
import com.example.checkpoint.model.UserCredentials;
import com.example.checkpoint.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Scanner;

@Component
public class UserAuthenticationManager implements AuthenticationManager<User> {
    private final UserService userService;

    @Autowired
    public UserAuthenticationManager(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User authenticate(String username, String password) {
        try {
            User user = userService.findByUserCredentials(username, password);
            var userCredentials = user.getUserCredentials();
            userCredentials.setEnteredAt(LocalDateTime.now());
            user.setUserCredentials(userCredentials);
            return user;

        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }
        return repeatAuthenticationRequest();
    }

    private User repeatAuthenticationRequest() {
        var scanner = new Scanner(System.in);
        String username, password;
        System.out.print("Enter username: ");
        username = scanner.next();
        System.out.print("Enter password: ");
        password = scanner.next() + "\n";
        return authenticate(username, password);
    }

}
