package com.oa.model;

public class WorkType {
	private Long wld; //主键
	private String WorkTypeId;//工作ID
	private String WorkName;//工作名称
	private String Content;//工作内容
	
	public WorkType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkType(Long wld, String workTypeId, String workName, String content) {
		super();
		this.wld = wld;
		WorkTypeId = workTypeId;
		WorkName = workName;
		Content = content;
	}

	public WorkType(String workTypeId, String workName, String content) {
		super();
		WorkTypeId = workTypeId;
		WorkName = workName;
		Content = content;
	}

	public Long getWld() {
		return wld;
	}

	public void setWld(Long wld) {
		this.wld = wld;
	}

	public String getWorkTypeId() {
		return WorkTypeId;
	}

	public void setWorkTypeId(String workTypeId) {
		WorkTypeId = workTypeId;
	}

	public String getWorkName() {
		return WorkName;
	}

	public void setWorkName(String workName) {
		WorkName = workName;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "WorkType [wld=" + wld + ", WorkTypeId=" + WorkTypeId
				+ ", WorkName=" + WorkName + ", Content=" + Content + "]";
	}
}
