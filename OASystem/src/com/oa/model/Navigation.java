package com.oa.model;

import java.io.Serializable;

public class Navigation implements Serializable{
	private Integer navId;
	private String navValue;
	private String navUrl;
	private String navClass;
	private Integer navParentId;
	private Integer navChildId;
	public Navigation() {
		super();
	}
	public Integer getNavId() {
		return navId;
	}
	public void setNavId(Integer navId) {
		this.navId = navId;
	}
	public String getNavValue() {
		return navValue;
	}
	public void setNavValue(String navValue) {
		this.navValue = navValue;
	}
	public String getNavUrl() {
		return navUrl;
	}
	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}
	public Integer getNavParentId() {
		return navParentId;
	}
	public void setNavParentId(Integer navParentId) {
		this.navParentId = navParentId;
	}
	public Integer getNavChildId() {
		return navChildId;
	}
	public void setNavChildId(Integer navChildId) {
		this.navChildId = navChildId;
	}
	public Navigation(Integer navId) {
		super();
		this.navId = navId;
	}
	public String getNavClass() {
		return navClass;
	}
	public void setNavClass(String navClass) {
		this.navClass = navClass;
	}
	
	
	
}
