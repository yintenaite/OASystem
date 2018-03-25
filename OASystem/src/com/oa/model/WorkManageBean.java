package com.oa.model;

import java.util.Date;

/** 
* @ClassName: workManageBean 
* @Description: TODO(这个一个工作管理的工具类) 
* @author 孟祥瑞 
* @date 2015年10月3日 下午1:42:54 
*  
*/
public class WorkManageBean {
	private Long workId; //工作编号
	private WorkType workType; //工作类型
	private Date workcreateTime;//工作创建时间
	private Integer workState; //工作状态
	
	public WorkManageBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkManageBean(Long workId, WorkType workType, Date workcreateTime,
			Integer workState) {
		super();
		this.workId = workId;
		this.workType = workType;
		this.workcreateTime = workcreateTime;
		this.workState = workState;
	}

	public Long getWorkId() {
		return workId;
	}

	public void setWorkId(Long workId) {
		this.workId = workId;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Date getWorkcreateTime() {
		return workcreateTime;
	}

	public void setWorkcreateTime(Date workcreateTime) {
		this.workcreateTime = workcreateTime;
	}

	public Integer getWorkState() {
		return workState;
	}

	public void setWorkState(Integer workState) {
		this.workState = workState;
	}

	@Override
	public String toString() {
		return "WorkManageBean [workId=" + workId + ", workType=" + workType
				+ ", workcreateTime=" + workcreateTime + ", workState="
				+ workState + "]";
	}
	
}
