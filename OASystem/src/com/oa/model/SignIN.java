package com.oa.model;


import java.util.Date;

public class SignIN {
	private int siId;              //标识
	private User userId;           //签到人用户ID
	private Date siDate;           //签到日期
	private Date siTime;           //签到时间
	//private int siState;           //签到状态  0表示签到    1表示未签到
	private String ip;                //签到位置
	public int getSiId() {
		return siId;
	}
	public void setSiId(int siId) {
		this.siId = siId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public Date getSiDate() {
		return siDate;
	}
	public void setSiDate(Date siDate) {
		this.siDate = siDate;
	}
	public Date getSiTime() {
		return siTime;
	}
	public void setSiTime(Date siTime) {
		this.siTime = siTime;
	}
/*	public int getSiState() {
		return siState;
	}
	public void setSiState(int siState) {
		this.siState = siState;
	}*/
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
}
