package com.example.registerservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.entity.User;
import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.service.AdminService;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping("/unblockUser/{id}/{adminId}")
	public ResponseEntity<Object> unBlockUser(@PathVariable Long id, @PathVariable Long adminId) {

		if (adminService.isAdminUser(adminId)) {
			if (adminService.unBlockUser(id)) {
				System.out.println("unblocking user");
			}
		} else {
			return new ResponseEntity<Object>("please login as admin", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Object>("unblock successfully", HttpStatus.OK);

	}
}
