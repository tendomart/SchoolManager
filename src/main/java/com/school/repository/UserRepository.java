package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.security.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
