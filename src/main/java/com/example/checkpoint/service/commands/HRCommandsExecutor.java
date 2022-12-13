package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.User;
import com.example.checkpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class HRCommandsExecutor implements CommandsExecutor {
    private final UserService userService;

    @Autowired
    public HRCommandsExecutor(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void executeCommands(User user, List<String> lines) {
        boolean status = true;
        while (status) {
            String command = commandRequest(lines);

            switch (command) {
                case "1" -> {
                    System.out.println(CHOICE_DECORATOR);
                    userService.composeAllUsersReport().forEach(System.out::println);
                    System.out.println(CHOICE_DECORATOR);
                }
                case "2" -> status = false;
                default -> {
                    System.out.println(ERROR_DECORATOR);
                    System.out.println("Such command does not exist!");
                    System.out.println(ERROR_DECORATOR);
                }
            }
        }
    }
}
