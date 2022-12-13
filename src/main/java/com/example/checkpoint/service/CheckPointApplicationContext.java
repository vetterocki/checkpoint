package com.example.checkpoint.service;

import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.User;
import com.example.checkpoint.model.menus.CheckPointMenu;
import com.example.checkpoint.service.commands.CommandsExecutor;
import com.example.checkpoint.service.commands.MenuConfigurer;
import com.example.checkpoint.service.security.AuthenticationManager;
import com.example.checkpoint.service.security.AuthorizationManager;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Component
public class CheckPointApplicationContext {
    AuthenticationManager<User> authenticationManager;
    AuthorizationManager<Role, CheckPointMenu> authorizationManager;
    MenuConfigurer menuConfigurer;

    public void executeContext() {
        boolean status = true;
        while (status) {
            System.out.println("~".repeat(12));
            System.out.println("Type 'login' to enter login.");
            System.out.println("Type 'exit' to terminate application.");

            var scanner = new Scanner(System.in);
            String choice = scanner.nextLine();

            switch (choice) {
                case "login" -> {
                    String username, password;
                    System.out.print("Enter username: ");
                    username = scanner.next();
                    System.out.print("Enter password: ");
                    password = scanner.next();
                    System.out.println();
                    var user = authenticationManager.authenticate(username, password);
                    var checkPointMenu = authorizationManager.authorize(user.getUserCredentials().getRole());
                    var commandsExecutor = menuConfigurer.configureMenu(checkPointMenu, user);
                    commandsExecutor.executeCommands(user, checkPointMenu.getMenuLines());

                }
                case "exit" -> status = false;
                default ->  {
                    System.out.println(".".repeat(12));
                    System.out.println("Such command does not exist!");
                    System.out.println(".".repeat(12));
                }
            }
        }

    }

}
