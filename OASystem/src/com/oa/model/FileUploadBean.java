package com.oa.model;

import java.util.Set;



public class FileUploadBean {

	private int fid;
	private String uploadFileName;
	private String savePath;
	private Diary diaryId;
	
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public Diary getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(Diary diaryId) {
		this.diaryId = diaryId;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	
}
