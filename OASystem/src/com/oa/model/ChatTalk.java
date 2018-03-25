package com.oa.model;

import java.util.Date;

/** 
* @ClassName: ChatTalk 
* @Description: TODO(这是一个用于实现聊天室的Bean) 
* @author 孟祥瑞 
* @date 2015年10月20日 下午3:41:52 
*  
*/
public class ChatTalk {
	private Long chartId;//ID
	private Date  chartDateTime = new Date();//聊天时间
	private String chartMessage;//聊天的内容
	private String chartUserName;//聊天的人
	
	
	
	public ChatTalk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChatTalk(Long chartId, Date chartDateTime, String chartMessage,
			String chartUserName) {
		super();
		this.chartId = chartId;
		this.chartDateTime = chartDateTime;
		this.chartMessage = chartMessage;
		this.chartUserName = chartUserName;
	}
	public ChatTalk(Date chartDateTime, String chartMessage,
			String chartUserName) {
		super();
		this.chartDateTime = chartDateTime;
		this.chartMessage = chartMessage;
		this.chartUserName = chartUserName;
	}
	public Long getChartId() {
		return chartId;
	}
	public void setChartId(Long chartId) {
		this.chartId = chartId;
	}
	public Date getChartDateTime() {
		return chartDateTime;
	}
	public void setChartDateTime(Date chartDateTime) {
		this.chartDateTime = chartDateTime;
	}
	public String getChartMessage() {
		return chartMessage;
	}
	public void setChartMessage(String chartMessage) {
		this.chartMessage = chartMessage;
	}
	public String getChartUserName() {
		return chartUserName;
	}
	public void setChartUserName(String chartUserName) {
		this.chartUserName = chartUserName;
	}
	@Override
	public String toString() {
		return "ChatTalk [chartId=" + chartId + ", chartDateTime="
				+ chartDateTime + ", chartMessage=" + chartMessage
				+ ", chartUserName=" + chartUserName + "]";
	}
}
