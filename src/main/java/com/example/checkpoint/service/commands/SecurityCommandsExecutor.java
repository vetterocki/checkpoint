package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.EnteredStatus;
import com.example.checkpoint.model.User;
import com.example.checkpoint.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SecurityCommandsExecutor implements CommandsExecutor {
    private final UserService userService;

    @Autowired
    public SecurityCommandsExecutor(UserService userService) {
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
                    List<User> users = userService.findAllByEnteringStatus(EnteredStatus.ENTERED);
                    if (users.size() != 0)
                        userService.usersFullName(users).forEach(System.out::println);
                    else
                        System.out.println("No one entered yet!");
                    System.out.println(CHOICE_DECORATOR);
                }
                case "2" -> {
                    System.out.println(CHOICE_DECORATOR);
                    Optional<User> found = userService.findLastUserEntered();
                    found.ifPresentOrElse(
                            (nonNull) -> System.out.println(userService.userFullName(nonNull)),
                            () -> System.out.println("No one entered yet!"));
                    System.out.println(CHOICE_DECORATOR);
                }
                case "3" -> status = false;
                default -> {
                    System.out.println(ERROR_DECORATOR);
                    System.out.println("Such command does not exist!");
                    System.out.println(ERROR_DECORATOR);
                }
            }
        }

    }
}
