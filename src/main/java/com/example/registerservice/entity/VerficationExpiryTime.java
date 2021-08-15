package com.example.registerservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VerficationExpiryTime {

	@Id
	@GeneratedValue
	private Long id;
	public Long linkExpiryTime;
	public Long otpExpiryTime;

	@Override
	public String toString() {
		return "VerficationExpiryTime [linkExpiryTime=" + linkExpiryTime + ", otpExpiryTime=" + otpExpiryTime + "]";
	}

	public Long getLinkExpiryTime() {
		return linkExpiryTime;
	}

	public void setLinkExpiryTime(Long linkExpiryTime) {
		this.linkExpiryTime = linkExpiryTime;
	}

	public Long getOtpExpiryTime() {
		return otpExpiryTime;
	}

	public void setOtpExpiryTime(Long otpExpiryTime) {
		this.otpExpiryTime = otpExpiryTime;
	}

	public VerficationExpiryTime(Long id, Long linkExpiryTime, Long otpExpiryTime) {
		super();
		this.id = id;
		this.linkExpiryTime = linkExpiryTime;
		this.otpExpiryTime = otpExpiryTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VerficationExpiryTime() {
		super();
		// TODO Auto-generated constructor stub
	}
}
