package com.example.registerservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.entity.User;
import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.repo.VerificationExpiryTimeRepo;
import com.example.registerservice.service.VerificationService;

@RestController
@RequestMapping("/verify")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class VerificationController {

	@Autowired
	VerificationService verificationService;

	@Autowired
	UserRepo userrepo;

	@Autowired
	VerificationExpiryTimeRepo verificationExpiryTimeRepo;

	@GetMapping("/email/{id}")
	public ResponseEntity<Object> verifyUserbyMail(@PathVariable Long id) {

		Optional<User> optionalUser = userrepo.findById(id);
		User user = null;
		if (optionalUser.isPresent()) {
			user = optionalUser.get();
		}
//verificationExpiryTimeRepo.findById(1L).get().getLinkExpiryTime()
		if (System.currentTimeMillis() - user.getRegisterTime() > 3600000) {

			return new ResponseEntity<>("Link is expire.", HttpStatus.GONE);
		}
		if (verificationService.makeVerifiedUser(id)) {
			return new ResponseEntity<>("email id verified.", HttpStatus.OK);
		}
		return new ResponseEntity<>("email id can not verified.", HttpStatus.BAD_REQUEST);

	}

}
