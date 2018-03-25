package com.oa.model;

import java.util.Date;
/**
 * 请假单类
 * @author mxr
 *
 */
public class LeaveBill {
	private Long lid;//主键
	private String leaveBillId; //请假单编号
	private Integer days;//请假天数
	private String content;//请假内容
	private Date leaveDate = new Date();// 创建时间
	private String leaveBillType;//请假类型
	private String remark;// 备注
	private User user;//请假人
	private Integer state = 0; //请假状态0初始录入,1.开始审批,2为审批完成
	private WorkType workType; //工作类型
	public LeaveBill() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LeaveBill(Long lid, String leaveBillId, Integer days,
			String content, Date leaveDate, String leaveBillType,
			String remark, User user, Integer state, WorkType workType) {
		super();
		this.lid = lid;
		this.leaveBillId = leaveBillId;
		this.days = days;
		this.content = content;
		this.leaveDate = leaveDate;
		this.leaveBillType = leaveBillType;
		this.remark = remark;
		this.user = user;
		this.state = state;
		this.workType = workType;
	}
	public LeaveBill(String leaveBillId, Integer days, String content,
			Date leaveDate, String leaveBillType, String remark, User user,
			Integer state, WorkType workType) {
		super();
		this.leaveBillId = leaveBillId;
		this.days = days;
		this.content = content;
		this.leaveDate = leaveDate;
		this.leaveBillType = leaveBillType;
		this.remark = remark;
		this.user = user;
		this.state = state;
		this.workType = workType;
	}
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getLeaveBillId() {
		return leaveBillId;
	}
	public void setLeaveBillId(String leaveBillId) {
		this.leaveBillId = leaveBillId;
	}
	public Integer getDays() {
		return days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getLeaveBillType() {
		return leaveBillType;
	}
	public void setLeaveBillType(String leaveBillType) {
		this.leaveBillType = leaveBillType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public WorkType getWorkType() {
		return workType;
	}
	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}
	@Override
	public String toString() {
		return "LeaveBill [lid=" + lid + ", leaveBillId=" + leaveBillId
				+ ", days=" + days + ", content=" + content + ", leaveDate="
				+ leaveDate + ", leaveBillType=" + leaveBillType + ", remark="
				+ remark + ", user=" + user + ", state=" + state
				+ ", workType=" + workType + "]";
	}
}
