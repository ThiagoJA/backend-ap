package com.backend.achadosperdidos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.achadosperdidos.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
