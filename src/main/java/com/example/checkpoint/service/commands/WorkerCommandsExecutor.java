package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.EnteredStatus;
import com.example.checkpoint.model.User;
import com.example.checkpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

@Component
public class WorkerCommandsExecutor implements CommandsExecutor {
    private final UserService userService;

    @Autowired
    public WorkerCommandsExecutor(UserService userService) {
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
                    user.setEnteredStatus(EnteredStatus.ENTERED);
                    user.setTodayAtWork(true);
                    userService.save(user);
                    System.out.println("You successfully entered the company building!");
                    System.out.println(CHOICE_DECORATOR);
                }
                case "2" -> {
                    System.out.println(CHOICE_DECORATOR);
                    user.setEnteredStatus(EnteredStatus.NOT_ENTERED);
                    userService.save(user);
                    System.out.println("You successfully left the company building!");
                    System.out.println(CHOICE_DECORATOR);
                }
                case "3" -> {
                    var userCredentials = user.getUserCredentials();
                    userCredentials.setLeftAt(LocalDateTime.now());
                    user.setUserCredentials(userCredentials);
                    userService.save(user);
                    status = false;
                }
                default ->  {
                    System.out.println(ERROR_DECORATOR);
                    System.out.println("Such command does not exist!");
                    System.out.println(ERROR_DECORATOR);
                }
            }

        }

    }

}
