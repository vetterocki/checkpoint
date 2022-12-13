package com.example.checkpoint;

import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.User;
import com.example.checkpoint.model.UserCredentials;
import com.example.checkpoint.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@AllArgsConstructor
@Configuration
public class DataSourceSupplier {
    private UserService userService;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            userService.save(createUser("Hal Koil Ponk", "koil", "123", Role.WORKER));
            userService.save(createUser("Man Lopi Loki", "loki", "123", Role.WORKER));
            userService.save(createUser("Joi Gonk Tore", "tore", "123", Role.WORKER));
            userService.save(createUser("Pon Adas Fore", "fore", "123", Role.WORKER));
            userService.save(createUser("Bla Falk Asoi", "asoi", "123", Role.WORKER));
            userService.save(createUser("Fag Qert Jiod", "jiod", "123", Role.WORKER));
            userService.save(createUser("You Zaka Werd", "werd", "123", Role.WORKER));
            userService.save(createUser("Kil Kilo Voil", "voil", "123", Role.WORKER));
            userService.save(createUser("Rte Qery Calk", "calk", "123", Role.WORKER));

            userService.save(createUser("Hr Worker First", "hr", "123", Role.HR));
            userService.save(createUser("Security Worker First", "sec", "123", Role.SECURITY));
        };
    }

    private User createUser(String fullName, String username, String password, Role role) {
        var userCredentials = new UserCredentials(username, password, role);
        List<String> strings = List.of(fullName.split(" "));
        return new User(strings.get(0), strings.get(1), strings.get(2), userCredentials);
    }
}
