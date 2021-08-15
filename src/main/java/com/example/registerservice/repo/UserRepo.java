package com.example.registerservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registerservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByEmailId(String email);

	Optional<User> findByEmailIdAndPassword(String emailId, String password);
}
