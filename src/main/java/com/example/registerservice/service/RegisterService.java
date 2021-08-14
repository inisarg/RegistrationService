package com.example.registerservice.service;

import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.registerservice.entity.User;
import com.example.registerservice.entity.VerifiedUser;
import com.example.registerservice.repo.UserRepo;
import com.example.registerservice.repo.VerifiedUserRepo;

@Service
public class RegisterService {
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	VerifiedUserRepo verifiedUserRepo;

	@Autowired
	private JavaMailSender javaMailSender;

	public User registerUser(User user) {
		return userRepo.save(user);
	}

	public boolean findUserByEmail(String email) {
		Optional<User> user = userRepo.findByEmailId(email);
		if (user.isPresent()) {
			return true;
		}
		return false;

	}

	public void sendVerificationMail(User user) throws MessagingException {
		/*
		 * SimpleMailMessage msg = new SimpleMailMessage();
		 * msg.setTo(user.getEmailId()); msg.setSubject("Testing from Spring Boot");
		 * msg.setText("Hello World \n Spring Boot Email");
		 */
		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg);
		helper.setSubject("verification mail");
		helper.setText("<a href='http://localhost:8080/verify/email/"+user.getId()+"'>Verify</a>", true);

		helper.setTo(user.getEmailId());

		javaMailSender.send(msg);
	}
	
	public void addVerifiedUser(VerifiedUser verifiedUser) {
		VerifiedUser vrifiedUser_r = verifiedUserRepo.save(verifiedUser);
		System.out.println(vrifiedUser_r);


	}
}
