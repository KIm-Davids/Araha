package com.semicolon.africa.arahasubcriptionapp.data.repositories;

import com.semicolon.africa.arahasubcriptionapp.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByPhoneNumber(String email);

    Optional<User> findByEmail(String email);

}
