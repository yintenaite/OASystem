package com.oa.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

public class Notice implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer noticeId;          //公告编号
	private String noticeTitle;        //公告标题
	private String noticeContent;      //公告内容
	private Date noticeTime;           //公告发布时间
	
	private String noticeType;		   //公告类型
	
	private User user;                 //发布公告的用户
	private Set<Department> departments;     //哪些部门可以看到


	public Integer getNoticeId() {
		return noticeId;
	}
	
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

}
