package com.example.registerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String emailId;
	private Long mobileNumber;
	private String password;
	@JsonProperty
	private boolean isAdmin;
	private Long registerTime;
	private int wrongAttemptCount;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", registerTime=" + registerTime + ", wrongAttemptCount="
				+ wrongAttemptCount + ", isAdmin=" + isAdmin + "]";
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public User(Long id, String name, String address, String emailId, Long mobileNumber, String password,
			Long registerTime, int wrongAttemptCount, boolean isAdmin) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.registerTime = registerTime;
		this.wrongAttemptCount = wrongAttemptCount;
		this.isAdmin = isAdmin;
	}

	public int getWrongAttemptCount() {
		return wrongAttemptCount;
	}

	public void setWrongAttemptCount(int wrongAttemptCount) {
		this.wrongAttemptCount = wrongAttemptCount;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Long registerTime) {
		this.registerTime = registerTime;
	}

}
