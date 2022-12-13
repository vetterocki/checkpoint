package com.example.checkpoint.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @NotBlank
    String firstName;

    @NotNull
    @NotBlank
    String lastName;

    @NotNull
    @NotBlank
    String middleName;

    @NotNull
    @Embedded
    UserCredentials userCredentials;

    @Enumerated(EnumType.STRING)
    EnteredStatus enteredStatus;

    boolean isTodayAtWork;

    public User(
            String firstName,
            String lastName,
            String middleName,
            UserCredentials userCredentials) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.userCredentials = userCredentials;
        this.isTodayAtWork = false;
        this.enteredStatus = EnteredStatus.NOT_ENTERED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
