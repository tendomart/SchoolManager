package com.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.security.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
