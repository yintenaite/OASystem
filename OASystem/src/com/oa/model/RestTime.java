package com.oa.model;

import java.sql.Time;

public class RestTime {
    private int rtId;                      //标识
	private Time onTime;                   //上班时间
	private Time offTime;                  //下班时间
	private Time rtStartTime;              //中午休息开始时间
	private Time rtFinalTime;              //中午休息结束时间
	public int getRtId() {
		return rtId;
	}
	public void setRtId(int rtId) {
		this.rtId = rtId;
	}
	public Time getOnTime() {
		return onTime;
	}
	public void setOnTime(Time onTime) {
		this.onTime = onTime;
	}
	public Time getOffTime() {
		return offTime;
	}
	public void setOffTime(Time offTime) {
		this.offTime = offTime;
	}
	public Time getRtStartTime() {
		return rtStartTime;
	}
	public void setRtStartTime(Time rtStartTime) {
		this.rtStartTime = rtStartTime;
	}
	public Time getRtFinalTime() {
		return rtFinalTime;
	}
	public void setRtFinalTime(Time rtFinalTime) {
		this.rtFinalTime = rtFinalTime;
	}
	
}
