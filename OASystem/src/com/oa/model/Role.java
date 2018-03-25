package com.oa.model;

import java.io.Serializable;

import org.apache.struts2.views.annotations.StrutsTag;

public class Role implements Serializable{
	private Integer roleId;
	private String roleName;
	private Integer roleParentId;
	private Integer roleChildId;
	private String roleRemark;
	private Department department;
	public Role() {
		super();
	}
	
	public Role(Integer roleId) {
		super();
		this.roleId = roleId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleParentId() {
		return roleParentId;
	}

	public void setRoleParentId(Integer roleParentId) {
		this.roleParentId = roleParentId;
	}

	public Integer getRoleChildId() {
		return roleChildId;
	}

	public void setRoleChildId(Integer roleChildId) {
		this.roleChildId = roleChildId;
	}

	public String getRoleRemark() {
		return roleRemark;
	}

	public void setRoleRemark(String roleRemark) {
		this.roleRemark = roleRemark;
	}

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	

	
}
