package com.oa.model;

import java.io.Serializable;
import java.util.Date;

public class News implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer newsId;			//新闻编号
	private String newsTitle;		//新闻标题
	private String newsContent;		//新闻内容
	private Date newsTime;			//新闻发布时间
	private Integer clickCount = 0;		//新闻点击次数  初始时默认为 0
	
	private Integer commentCount = 0;   //评论条数，默认 0 条
	
	private User user;				//发布新闻的用户
	
	public Integer getClickCount() {
		return clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}
 
	public Integer getNewsId() {
		return newsId;
	}

	public void setNewsId(Integer newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}

	public Date getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	
}
