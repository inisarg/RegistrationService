package com.example.registerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class VerifiedUser {
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne
	private User user;
	private boolean isEmailVerified;

	@Override
	public String toString() {
		return "VerifiedUser [id=" + id + ", user=" + user + ", isEmailVerified=" + isEmailVerified + "]";
	}

	public VerifiedUser(Long id, User user, boolean isEmailVerified) {
		super();
		this.id = id;
		this.user = user;
		this.isEmailVerified = isEmailVerified;
	}

	public VerifiedUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isEmailVerified() {
		return isEmailVerified;
	}

	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}
}
