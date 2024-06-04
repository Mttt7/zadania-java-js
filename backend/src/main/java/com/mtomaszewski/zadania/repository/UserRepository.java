package com.mtomaszewski.zadania.repository;

import com.mtomaszewski.zadania.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);
}
