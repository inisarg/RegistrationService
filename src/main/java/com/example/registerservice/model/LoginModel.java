package com.example.registerservice.model;

public class LoginModel {

	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginModel [email=" + email + ", password=" + password + "]";
	}

	public LoginModel(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}

}
