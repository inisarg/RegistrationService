package com.example.registerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.registerservice.entity.VerficationExpiryTime;
import com.example.registerservice.repo.VerificationExpiryTimeRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = { RequestMethod.POST, RequestMethod.GET,
		RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS })
public class VerificationExpiryTimeController {

	@Autowired
	VerificationExpiryTimeRepo verficationExpiryTime;

//in milliseconds
	@PutMapping("/expiryTime/email/{expiryTimeToUpdate}/update")
	public void updateLinkExpiryTime(@PathVariable Long expiryTimeToUpdate) {
		VerficationExpiryTime objVerficationExpiryTime = verficationExpiryTime.findById(1L).get();

		objVerficationExpiryTime.setLinkExpiryTime(expiryTimeToUpdate);
		verficationExpiryTime.save(objVerficationExpiryTime);
	}

	// not implimented
	@PutMapping("/expiryTime/otp/{id}/update")
	public void updateOtpExpiryTime(@PathVariable Long id) {

	}

}
