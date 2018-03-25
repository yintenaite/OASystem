package com.oa.model;

import java.io.Serializable;

public class Role_Nav implements Serializable{
	private Integer rnId;
	private Role role;
	private Navigation navigation;
	public Role_Nav() {
		super();
	}
	public Integer getRnId() {
		return rnId;
	}
	public void setRnId(Integer rnId) {
		this.rnId = rnId;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Navigation getNavigation() {
		return navigation;
	}
	public void setNavigation(Navigation navigation) {
		this.navigation = navigation;
	}
	public Role_Nav(Role role, Navigation navigation) {
		super();
		this.role = role;
		this.navigation = navigation;
	}

	
	
}
