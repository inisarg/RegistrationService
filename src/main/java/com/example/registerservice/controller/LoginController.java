package com.example.registerservice.controller;

import java.util.List;
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

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class LoginController {

	@Autowired
	UserRepo userRepo;

	@Autowired
	VerifiedUserRepo verifiedUserRepo;

	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody LoginModel loginModel) throws Exception {

		System.out.println(loginModel);
		List<User> userList = userRepo.findAll();
		for (User user : userList) {
			if (loginModel.getEmail().equals(user.getEmailId())
					&& loginModel.getPassword().equals(user.getPassword())) {
				return new ResponseEntity<>("user login successfully.", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("user not logdin successfully.", HttpStatus.UNAUTHORIZED);
	}
}
