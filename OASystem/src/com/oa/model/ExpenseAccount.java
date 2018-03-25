package com.oa.model;

import java.util.Date;


/** 
* @ClassName: ExpenseAccount 
* @Description: TODO(报销单借款单类) 
* @author 孟祥瑞 
* @date 2015年10月1日 下午6:59:20 
*  
*/
//注意在建实体的时候大写字母的前面必须有三个小写字母
public class ExpenseAccount {
	private Long exaid;//主键
	private String expenseAcId;//报销单ID
	private Double exaMoney;//报销金额
	private Integer borrowDate;//借款天数
	private Date expenseAcDate = new Date();//报销日期
	private String expenseAcType; //报销类型
	private String exaRemark;//报销说明
	private User exaUser; //报销人
	private Integer exaState = 0;//报销状态0初始录入,1.开始审批,2为审批完成
	private String exaImageSrc;//报销单的文件的路径
	private WorkType exaWorkType;//工作类型
	public ExpenseAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExpenseAccount(Long exaid, String expenseAcId, Double exaMoney,
			Integer borrowDate, Date expenseAcDate, String expenseAcType,
			String exaRemark, User exaUser, Integer exaState,
			String exaImageSrc, WorkType exaWorkType) {
		super();
		this.exaid = exaid;
		this.expenseAcId = expenseAcId;
		this.exaMoney = exaMoney;
		this.borrowDate = borrowDate;
		this.expenseAcDate = expenseAcDate;
		this.expenseAcType = expenseAcType;
		this.exaRemark = exaRemark;
		this.exaUser = exaUser;
		this.exaState = exaState;
		this.exaImageSrc = exaImageSrc;
		this.exaWorkType = exaWorkType;
	}
	public ExpenseAccount(String expenseAcId, Double exaMoney,
			Integer borrowDate, Date expenseAcDate, String expenseAcType,
			String exaRemark, User exaUser, Integer exaState,
			String exaImageSrc, WorkType exaWorkType) {
		super();
		this.expenseAcId = expenseAcId;
		this.exaMoney = exaMoney;
		this.borrowDate = borrowDate;
		this.expenseAcDate = expenseAcDate;
		this.expenseAcType = expenseAcType;
		this.exaRemark = exaRemark;
		this.exaUser = exaUser;
		this.exaState = exaState;
		this.exaImageSrc = exaImageSrc;
		this.exaWorkType = exaWorkType;
	}
	public Long getExaid() {
		return exaid;
	}
	public void setExaid(Long exaid) {
		this.exaid = exaid;
	}
	public String getExpenseAcId() {
		return expenseAcId;
	}
	public void setExpenseAcId(String expenseAcId) {
		this.expenseAcId = expenseAcId;
	}
	public Double getExaMoney() {
		return exaMoney;
	}
	public void setExaMoney(Double exaMoney) {
		this.exaMoney = exaMoney;
	}
	public Integer getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Integer borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getExpenseAcDate() {
		return expenseAcDate;
	}
	public void setExpenseAcDate(Date expenseAcDate) {
		this.expenseAcDate = expenseAcDate;
	}
	public String getExpenseAcType() {
		return expenseAcType;
	}
	public void setExpenseAcType(String expenseAcType) {
		this.expenseAcType = expenseAcType;
	}
	public String getExaRemark() {
		return exaRemark;
	}
	public void setExaRemark(String exaRemark) {
		this.exaRemark = exaRemark;
	}
	public User getExaUser() {
		return exaUser;
	}
	public void setExaUser(User exaUser) {
		this.exaUser = exaUser;
	}
	public Integer getExaState() {
		return exaState;
	}
	public void setExaState(Integer exaState) {
		this.exaState = exaState;
	}
	public String getExaImageSrc() {
		return exaImageSrc;
	}
	public void setExaImageSrc(String exaImageSrc) {
		this.exaImageSrc = exaImageSrc;
	}
	public WorkType getExaWorkType() {
		return exaWorkType;
	}
	public void setExaWorkType(WorkType exaWorkType) {
		this.exaWorkType = exaWorkType;
	}
	@Override
	public String toString() {
		return "ExpenseAccount [exaid=" + exaid + ", expenseAcId="
				+ expenseAcId + ", exaMoney=" + exaMoney + ", borrowDate="
				+ borrowDate + ", expenseAcDate=" + expenseAcDate
				+ ", expenseAcType=" + expenseAcType + ", exaRemark="
				+ exaRemark + ", exaUser=" + exaUser + ", exaState=" + exaState
				+ ", exaImageSrc=" + exaImageSrc + ", exaWorkType="
				+ exaWorkType + "]";
	}
}
