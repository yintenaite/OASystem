package com.oa.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Diary {
	private int diaryId; 
	private String diaryTitle;
	private String diaryContent;
	private Date createTime;
	private int isShare;
	private User shareWho;
	private int diaryType;
	private int  browseNum;
	private Set<FileUploadBean> fid=new HashSet<FileUploadBean>();
	
	
	
	public Set<FileUploadBean> getFid() {
		return fid;
	}
	public void setFid(Set<FileUploadBean> fid) {
		this.fid = fid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public String getDiaryTitle() {
		return diaryTitle;
	}
	public void setDiaryTitle(String diaryTitle) {
		this.diaryTitle = diaryTitle;
	}
	public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	public int getIsShare() {
		return isShare;
	}
	public void setIsShare(int isShare) {
		this.isShare = isShare;
	}
	public User getShareWho() {
		return shareWho;
	}
	public void setShareWho(User shareWho) {
		this.shareWho = shareWho;
	}
	public int getDiaryType() {
		return diaryType;
	}
	public void setDiaryType(int diaryType) {
		this.diaryType = diaryType;
	}
	public int getBrowseNum() {
		return browseNum;
	}
	public void setBrowseNum(int browseNum) {
		this.browseNum = browseNum;
	}
	
	
	
}
