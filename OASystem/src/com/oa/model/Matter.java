package com.oa.model;

import java.util.Date;

public class Matter {
	private int busId;
	private String busTitle;		//事务标题
	private String busContent;		//事务内容
	private Date busCreateTime;		//创建时间
	private int busState;			//事务状态（待办0，在办1，完成2，取消3）
	private int busPriority;		//事务优先级（紧急0，普通1）
	private User buid;
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getBusTitle() {
		return busTitle;
	}
	public void setBusTitle(String busTitle) {
		this.busTitle = busTitle;
	}
	public String getBusContent() {
		return busContent;
	}
	public void setBusContent(String busContent) {
		this.busContent = busContent;
	}
	public Date getBusCreateTime() {
		return busCreateTime;
	}
	public void setBusCreateTime(Date busCreateTime) {
		this.busCreateTime = busCreateTime;
	}
	public int getBusState() {
		return busState;
	}
	public void setBusState(int busState) {
		this.busState = busState;
	}
	public int getBusPriority() {
		return busPriority;
	}
	public void setBusPriority(int busPriority) {
		this.busPriority = busPriority;
	}
	public User getBuid() {
		return buid;
	}
	public void setBuid(User buid) {
		this.buid = buid;
	}
	
	
	

}
