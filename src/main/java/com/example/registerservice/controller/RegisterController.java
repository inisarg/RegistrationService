package com.example.registerservice.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.registerservice.entity.User;
import com.example.registerservice.entity.VerifiedUser;
import com.example.registerservice.service.RegisterService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class RegisterController {
	@Autowired
	RegisterService registerService;

	@PostMapping("/register/user")
	public ResponseEntity<Object> registerUser(@RequestBody User user) throws Exception {
		System.out.println(user);

		if (registerService.findUserByEmail(user.getEmailId())) {
			System.out.println("this emailid taken....");
			return new ResponseEntity<>("this email id is already taken!", HttpStatus.CONFLICT);

		}
		user.setRegisterTime(System.currentTimeMillis());
		user.setWrongAttemptCount(0);

		user = registerService.registerUser(user);

		try {
			registerService.sendVerificationMail(user);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		VerifiedUser verifiedUser = new VerifiedUser();
		verifiedUser.setUser(user);
		verifiedUser.setEmailVerified(false);
		registerService.addVerifiedUser(verifiedUser);
		return new ResponseEntity<>("user register successfully.", HttpStatus.OK);

	}
}
