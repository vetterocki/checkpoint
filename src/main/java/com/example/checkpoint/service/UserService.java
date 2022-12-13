package com.example.checkpoint.service;

import com.example.checkpoint.data.UserRepository;
import com.example.checkpoint.exceptions.UserNotFoundException;
import com.example.checkpoint.exceptions.WrongPasswordException;
import com.example.checkpoint.model.EnteredStatus;
import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;


@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserCredentials(String username, String password) {
        return userRepository.findByUserCredentials_Username(username)
                .map(user -> {
                    if (user.getUserCredentials().getPassword().equals(password))
                        return user;
                    else throw new WrongPasswordException(username);
                })
                .orElseThrow(() -> new UserNotFoundException(username));

    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findLastUserEntered() {
        return userRepository.findAllByUserCredentials_Role(Role.WORKER)
                .stream()
                .filter(user -> Objects.nonNull(user.getUserCredentials().getEnteredAt()))
                .min(Comparator.comparing(o -> o.getUserCredentials().getEnteredAt()));
    }

    public List<User> findAllByEnteringStatus(EnteredStatus enteredStatus) {
        return userRepository.findAllByEnteredStatus(enteredStatus);
    }


    public List<String> usersFullName(List<User> users) {
        return users.stream()
                .map(this::userFullName)
                .toList();
    }

    public String userFullName(User user) {
        return user.getFirstName() + " " + user.getLastName() + " " + user.getMiddleName();
    }

    public List<String> composeAllUsersReport() {
        return userRepository.findAllByUserCredentials_Role(Role.WORKER)
                .stream()
                .sorted(Comparator
                        .comparing((Function<User, String>) user -> user.getEnteredStatus().name())
                        .thenComparing(User::isTodayAtWork))
                .map(user -> {
                    if (user.getEnteredStatus().equals(EnteredStatus.ENTERED))
                        return "IN THE COMPANY BUILDING NOW -> " + userFullName(user);
                    else {
                        if (user.isTodayAtWork())
                            return "NOT AT THE COMPANY BUILDING NOW -> " + userFullName(user);
                        else
                            return "NOT AT WORK AT ALL TODAY -> " + userFullName(user);
                    }
                })
                .toList();
    }
}
