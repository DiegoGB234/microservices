package com.microsvices.users_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microsvices.users_service.entity.User;



public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User>  findByUsername(String username);
}
