package com.oa.model;

public class ReceiveMsg {
	 private int rmId;               //标识
	 private User receiver;          //信息对应的收件人
	 private Message message;            //对应的信息
	 private int readState;            //信息状态   0为已读    1为未读
	 private int isdelete;           //发件箱的信息删除状态    0为未删除    1为已删除
	 private Integer isRMdelete;           //收件箱的信息删除状态    0为未删除    1为已删除
	 private Integer isTrashdelete;           //垃圾箱的信息删除状态    0为未删除    1为已删除
	public int getRmId() {
		return rmId;
	}
	public void setRmId(int rmId) {
		this.rmId = rmId;
	}
	public User getReceiver() {
		return receiver;
	}
	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public int getReadState() {
		return readState;
	}
	public void setReadState(int readState) {
		this.readState = readState;
	}
	public int getIsdelete() {
		return isdelete;
	}
	public void setIsdelete(int isdelete) {
		this.isdelete = isdelete;
	}
	public Integer getIsRMdelete() {
		return isRMdelete;
	}
	public void setIsRMdelete(Integer isRMdelete) {
		this.isRMdelete = isRMdelete;
	}
	public Integer getIsTrashdelete() {
		return isTrashdelete;
	}
	public void setIsTrashdelete(Integer isTrashdelete) {
		this.isTrashdelete = isTrashdelete;
	}
	
	 
}