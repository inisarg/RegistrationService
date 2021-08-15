package com.example.registerservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerservice.entity.User;
import com.example.registerservice.repo.UserRepo;

@Service
public class AdminService {

	@Autowired
	UserRepo userRepo;

	public boolean isAdminUser(Long id) {
		Optional<User> optAdminUser = userRepo.findById(id);
		if (optAdminUser.isPresent()) {
			User admin = optAdminUser.get();
			if (admin.isAdmin()) {
				return true;
			}
		}
		return false;

	}

	public boolean unBlockUser(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		if (optUser.isPresent()) {
			User user = optUser.get();
			user.setWrongAttemptCount(0);
			userRepo.save(user);
			return true;
		}
		return false;
	}

}
