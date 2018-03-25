package com.oa.model;
/**
* 考情表
* @ClassName: Attendance 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author 孟祥瑞 
* @date 2015年10月15日 下午3:17:00 
*
 */
public class Attendance {
	private Long attId;//主键
	private String attendanceId;//考勤单ID
	private String attDateTime;//考勤日期
	private Integer attendanceDate;//出勤天数
	private String attRemark;//考勤备注
	public Attendance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attendance(String attendanceId, String attDateTime,
			Integer attendanceDate, String attRemark) {
		super();
		this.attendanceId = attendanceId;
		this.attDateTime = attDateTime;
		this.attendanceDate = attendanceDate;
		this.attRemark = attRemark;
	}

	public Attendance(Long attId, String attendanceId, String attDateTime,
			Integer attendanceDate, String attRemark) {
		super();
		this.attId = attId;
		this.attendanceId = attendanceId;
		this.attDateTime = attDateTime;
		this.attendanceDate = attendanceDate;
		this.attRemark = attRemark;
	}

	public Long getAttId() {
		return attId;
	}

	public void setAttId(Long attId) {
		this.attId = attId;
	}

	public String getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(String attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getAttDateTime() {
		return attDateTime;
	}

	public void setAttDateTime(String attDateTime) {
		this.attDateTime = attDateTime;
	}

	public Integer getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Integer attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getAttRemark() {
		return attRemark;
	}

	public void setAttRemark(String attRemark) {
		this.attRemark = attRemark;
	}

	@Override
	public String toString() {
		return "Attendance [attId=" + attId + ", attendanceId=" + attendanceId
				+ ", attDateTime=" + attDateTime + ", attendanceDate="
				+ attendanceDate + ", attRemark=" + attRemark + "]";
	}
}
