package com.example.checkpoint.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Embeddable
public class UserCredentials {
    @NotNull
    @NotBlank
    String username;

    @NotNull
    @NotBlank
    String password;

    @Enumerated(EnumType.STRING)
    Role role;

    LocalDateTime enteredAt;
    LocalDateTime leftAt;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserCredentials(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
