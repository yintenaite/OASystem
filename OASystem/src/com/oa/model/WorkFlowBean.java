package com.oa.model;

import java.io.File;

public class WorkFlowBean {
	private File uploadfile;  //流程定义部署文件
	private String fileName; //流程定义名称
	private Long id; //申请单ID
	private Long lid;
	private String deploymentId; //部署对象ID
	private String imageName; //资源文件名称
	private String taskId; //任务ID
	private String outcome; //连线名称
	private String commemt; 	//备注
	private String message; //信息
	private String result; //验证
	private String uploadfileContentType;
	private String uploadfileFileName;
	private Long workId;
	private String workName;
	public WorkFlowBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public WorkFlowBean(File uploadfile, String fileName, Long id, Long lid,
			String deploymentId, String imageName, String taskId,
			String outcome, String commemt, String message, String result,
			String uploadfileContentType, String uploadfileFileName,
			Long workId, String workName) {
		super();
		this.uploadfile = uploadfile;
		this.fileName = fileName;
		this.id = id;
		this.lid = lid;
		this.deploymentId = deploymentId;
		this.imageName = imageName;
		this.taskId = taskId;
		this.outcome = outcome;
		this.commemt = commemt;
		this.message = message;
		this.result = result;
		this.uploadfileContentType = uploadfileContentType;
		this.uploadfileFileName = uploadfileFileName;
		this.workId = workId;
		this.workName = workName;
	}
	public File getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getLid() {
		return lid;
	}
	public void setLid(Long lid) {
		this.lid = lid;
	}
	public String getDeploymentId() {
		return deploymentId;
	}
	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public String getCommemt() {
		return commemt;
	}
	public void setCommemt(String commemt) {
		this.commemt = commemt;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUploadfileContentType() {
		return uploadfileContentType;
	}
	public void setUploadfileContentType(String uploadfileContentType) {
		this.uploadfileContentType = uploadfileContentType;
	}
	public String getUploadfileFileName() {
		return uploadfileFileName;
	}
	public void setUploadfileFileName(String uploadfileFileName) {
		this.uploadfileFileName = uploadfileFileName;
	}
	public Long getWorkId() {
		return workId;
	}
	public void setWorkId(Long workId) {
		this.workId = workId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	@Override
	public String toString() {
		return "WorkFlowBean [uploadfile=" + uploadfile + ", fileName="
				+ fileName + ", id=" + id + ", lid=" + lid + ", deploymentId="
				+ deploymentId + ", imageName=" + imageName + ", taskId="
				+ taskId + ", outcome=" + outcome + ", commemt=" + commemt
				+ ", message=" + message + ", result=" + result
				+ ", uploadfileContentType=" + uploadfileContentType
				+ ", uploadfileFileName=" + uploadfileFileName + ", workId="
				+ workId + ", workName=" + workName + "]";
	}
}
