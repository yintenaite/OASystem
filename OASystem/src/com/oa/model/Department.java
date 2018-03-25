package com.oa.model;

import java.io.Serializable;
import java.util.Date;

public class Department implements Serializable{
	private Integer deptId;//����id
	private Integer deptBh;//���ű��
	private String deptName;//��������
	private Integer deptStaffCount;//��ְԱ����
	private String deptPhone;//���ŵ绰
	private Date deptCreateTime;//����ʱ��
	private String deptRemark;//��ע
	private Integer deptParentId;
	private Integer deptChildId;
	
	public Department() {
		super();
	}



	public Integer getDeptId() {
		return deptId;
	}



	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}



	public Integer getDeptBh() {
		return deptBh;
	}



	public void setDeptBh(Integer deptBh) {
		this.deptBh = deptBh;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public Integer getDeptStaffCount() {
		return deptStaffCount;
	}



	public void setDeptStaffCount(Integer deptStaffCount) {
		this.deptStaffCount = deptStaffCount;
	}



	public String getDeptPhone() {
		return deptPhone;
	}



	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}



	public Date getDeptCreateTime() {
		return deptCreateTime;
	}



	public void setDeptCreateTime(Date deptCreateTime) {
		this.deptCreateTime = deptCreateTime;
	}



	public String getDeptRemark() {
		return deptRemark;
	}



	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}



	public Integer getDeptParentId() {
		return deptParentId;
	}


	public void setDeptParentId(Integer deptParentId) {
		this.deptParentId = deptParentId;
	}


	public Integer getDeptChildId() {
		return deptChildId;
	}


	public void setDeptChildId(Integer deptChildId) {
		this.deptChildId = deptChildId;
	}
	
}
