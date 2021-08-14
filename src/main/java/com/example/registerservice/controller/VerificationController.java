package com.example.registerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.service.VerificationService;

@RestController
@RequestMapping("/verify")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class VerificationController {

	@Autowired
	VerificationService verificationService;

	@GetMapping("/email/{id}")
	public ResponseEntity<Object> verifyUserbyMail(@PathVariable Long id) {
		if (verificationService.makeVerifiedUser(id)) {
			return new ResponseEntity<>("email id verified.", HttpStatus.OK);
		}
		return new ResponseEntity<>("email id can not verified.", HttpStatus.BAD_REQUEST);

	}

}
