package com.oa.model;

import java.util.Date;

public class SignOut {
	private int soId; // 标识
	private User userId; // 签退人用户ID
	private Date soDate; // 签退日期
	private Date soTime; // 签退时间
	// private int soState; // 签退状态 0表示正常 1表示早退
	private String ip; // 签退位置

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getSoDate() {
		return soDate;
	}

	public void setSoDate(Date soDate) {
		this.soDate = soDate;
	}

	public Date getSoTime() {
		return soTime;
	}

	public void setSoTime(Date soTime) {
		this.soTime = soTime;
	}

	// public int getSoState() {
	// return soState;
	// }
	// public void setSoState(int soState) {
	// this.soState = soState;
	// }
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

}
