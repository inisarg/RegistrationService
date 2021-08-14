package com.example.registerservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registerservice.entity.User;
import com.example.registerservice.entity.VerifiedUser;
import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.repo.VerifiedUserRepo;

@Service
public class VerificationService {
	@Autowired
	UserRepo userRepo;

	@Autowired
	VerifiedUserRepo verifiedUserRepo;

	public boolean makeVerifiedUser(Long id) {

		Optional<User> usr = userRepo.findById(id);
		Optional<VerifiedUser> vr_user = verifiedUserRepo.findByUser(usr.get());

		if (vr_user.isPresent()) {
			VerifiedUser verifiedUser = vr_user.get();

			verifiedUser.setEmailVerified(true);
			System.out.println(verifiedUser);

			verifiedUserRepo.save(verifiedUser);
			return true;
		}
		return false;
	}

}
