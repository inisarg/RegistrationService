package com.example.registerservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.registerservice.entity.User;
import com.example.registerservice.entity.VerifiedUser;

public interface VerifiedUserRepo extends JpaRepository<VerifiedUser, Long> {
	Optional<VerifiedUser> findByUser(User user);

}
