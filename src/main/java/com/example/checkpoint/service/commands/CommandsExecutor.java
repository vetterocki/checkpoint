package com.example.checkpoint.service.commands;

import com.example.checkpoint.model.User;

import java.util.List;
import java.util.Scanner;

public interface CommandsExecutor {
    String CHOICE_DECORATOR = "-".repeat(12);
    String ERROR_DECORATOR = ".".repeat(12);
    String GLOBAL_DECORATOR = "~".repeat(12);
    void executeCommands(User user, List<String> lines);

    default String commandRequest(List<String> lines) {
        System.out.println(GLOBAL_DECORATOR);
        lines.forEach(System.out::println);
        var scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
