package com.oa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Message {
	private int msId;                  //标识
	private String title;              //标题
	private String content;            //内容
	private Date sendTime;             //发件时间
	private User sender;               //发件人
	private int states;                //状态   0为已发  1为存到草稿箱
	private int isdelete;              //删除状态   0为未删除   1为已删除
	private Set<ReceiveMsg> receiveMsg = new HashSet<ReceiveMsg>();
	public int getMsId() {
		return msId;
	}
	public void setMsId(int msId) {
		this.msId = msId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public User getSender() {
		return sender;
	}
	public void setSender(User sender) {
		this.sender = sender;
	}
	public int getStates() {
		return states;
	}
	public void setStates(int states) {
		this.states = states;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public Set<ReceiveMsg> getReceiveMsg() {
		return receiveMsg;
	}
	public void setReceiveMsg(Set<ReceiveMsg> receiveMsg) {
		this.receiveMsg = receiveMsg;
	}
	public void addRM(ReceiveMsg rm){
		this.receiveMsg.add(rm);
	}

	
}
