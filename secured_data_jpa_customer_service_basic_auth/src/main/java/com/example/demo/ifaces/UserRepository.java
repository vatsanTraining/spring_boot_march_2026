package com.example.demo.ifaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.WebUser;

public interface UserRepository extends JpaRepository<WebUser, Long> {

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	Optional<WebUser> findByUsername(String username);

}
