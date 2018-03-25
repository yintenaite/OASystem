package com.oa.model;

import java.io.Serializable;
import java.util.Date;

public class UserProfile  implements Serializable{
	private String userBh;//�û����
	private Character  userGender;//�Ա�
	private String userIdCard;//���֤��
	private String userPhone;//�ֻ���
	private String userBirthday;//��������
	private Date userCreateTime;//ע������
	private String userEmail;//Email��ַ
	private String userRemark;//��ע
	
	public UserProfile() {
		super();
	}

	public String getUserBh() {
		return userBh;
	}

	public void setUserBh(String userBh) {
		this.userBh = userBh;
	}

	public Character getUserGender() {
		return userGender;
	}

	public void setUserGender(Character userGender) {
		this.userGender = userGender;
	}

	public String getUserIdCard() {
		return userIdCard;
	}

	public void setUserIdCard(String userIdCard) {
		this.userIdCard = userIdCard;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserRemark() {
		return userRemark;
	}

	public void setUserRemark(String userRemark) {
		this.userRemark = userRemark;
	}

	
	
}
