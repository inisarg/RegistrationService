package com.example.registerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.repo.VerifiedUserRepo;

@Service
public class LoginService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	VerifiedUserRepo verifiedUserRepo;

}
