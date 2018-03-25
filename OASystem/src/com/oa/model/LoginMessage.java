package com.oa.model;

public class LoginMessage {
	private int lmUserId;
	private String lmIp;
	
	public LoginMessage(int lmUserId, String lmIp) {
		super();
		this.lmUserId = lmUserId;
		this.lmIp = lmIp;
	}

	public LoginMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLmUserId() {
		return lmUserId;
	}

	public void setLmUserId(int lmUserId) {
		this.lmUserId = lmUserId;
	}

	public String getLmIp() {
		return lmIp;
	}

	public void setLmIp(String lmIp) {
		this.lmIp = lmIp;
	}
	
	
}
