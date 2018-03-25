package com.oa.model;

public class Notice_Department {

	private Integer ndId;
	private Notice notice;
	private Department department;

	public Integer getNdId() {
		return ndId;
	}

	public void setNdId(Integer ndId) {
		this.ndId = ndId;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
