package com.example.checkpoint.data;

import com.example.checkpoint.model.EnteredStatus;
import com.example.checkpoint.model.Role;
import com.example.checkpoint.model.User;
import com.example.checkpoint.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserCredentials_Username(String username);
    List<User> findAllByEnteredStatus(EnteredStatus enteredStatus);
    List<User> findAllByUserCredentials_Role(Role role);
}
