package com.example.registerservice.controller;

import java.util.Optional;

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
import com.example.registerservice.model.LoginModel;
import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.repo.VerifiedUserRepo;
import com.example.registerservice.service.VerificationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class LoginController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	VerifiedUserRepo verifiedUserRepo;

	@Autowired
	VerificationService verificationService;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginModel loginModel) throws Exception {

		if (verificationService.checkVerifiedUserFromEmailId(loginModel.getEmail())) {
			Optional<User> optUser = userRepo.findByEmailIdAndPassword(loginModel.getEmail(), loginModel.getPassword());
			if (optUser.isPresent()) {
				User usr = optUser.get();
				usr.setWrongAttemptCount(0);
				userRepo.save(usr);
				return new ResponseEntity<>("user logdin successfully.", HttpStatus.OK);
			} else {
				//

				User usr = userRepo.findByEmailId(loginModel.getEmail()).get();
				int count = usr.getWrongAttemptCount();
				if (count < 3) {
					usr.setWrongAttemptCount(count + 1);
					userRepo.save(usr);
				} else if (count == 3) {
					return new ResponseEntity<>("user is block, please contact admin", HttpStatus.LOCKED);

				}
				return new ResponseEntity<>("invalid emailid", HttpStatus.NOT_FOUND);

			}
		}

		return new ResponseEntity<>("user is not vaerified.", HttpStatus.UNAUTHORIZED);
	}
}
