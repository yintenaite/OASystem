package com.oa.model;

import java.io.File;

/** 
* @ClassName: UploadBean 
* @Description: TODO(文件上传Bean) 
* @author 孟祥瑞 
* @date 2015年10月2日 上午10:29:43 
*  
*/
public class UploadBean {
	  // 封装上传文件域的属性
    private File imageFile;
    // 封装上传文件类型的属性ContentType必须有前面为文件的名称
    private String imageFileContentType;
    // 封装上传文件名的属性FileName必须有前面为文件的名称
    private String imageFileFileName;

	public UploadBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadBean(File imageFile, String imageFileContentType,
			String imageFileFileName) {
		super();
		this.imageFile = imageFile;
		this.imageFileContentType = imageFileContentType;
		this.imageFileFileName = imageFileFileName;
	}

	public File getImageFile() {
		return imageFile;
	}

	public void setImageFile(File imageFile) {
		this.imageFile = imageFile;
	}

	public String getImageFileContentType() {
		return imageFileContentType;
	}

	public void setImageFileContentType(String imageFileContentType) {
		this.imageFileContentType = imageFileContentType;
	}

	public String getImageFileFileName() {
		return imageFileFileName;
	}

	public void setImageFileFileName(String imageFileFileName) {
		this.imageFileFileName = imageFileFileName;
	}

	@Override
	public String toString() {
		return "UploadBean [imageFile=" + imageFile + ", imageFileContentType="
				+ imageFileContentType + ", imageFileFileName="
				+ imageFileFileName + "]";
	}
}
