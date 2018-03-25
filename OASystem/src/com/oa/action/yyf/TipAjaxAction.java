package com.oa.action.yyf;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.oa.model.User;
import com.oa.service.yyf.LoginMessageService;
import com.oa.tools.login.IpUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TipAjaxAction extends ActionSupport{
	private static final long serialVersionUID = -4061358844378651682L;
	private LoginMessageService loginMessageService;
	private static String result;
	private String hasSession;
	private String hostIp;
	private String userIp;
	//private String refreshFlag;
	/**
	 * 在主页页面加载时
	 * @return String
	 */
	@SuppressWarnings("static-access")
	@JSON(serialize = false)
	public String getIp(){  //result : null  没有此账号信息
							//		   same	 与此账号信息相同
							//		   different  与此账号信息不同（异地登陆）
							//		   userSessionNull session无user值（session过期）
		User user = (User)ActionContext.getContext().getSession().get("user");
		userIp = IpUtil.getClientId(ServletActionContext.getRequest());
		if(user != null){//如果session中user为空，则直接跳回页面并转入登陆页面
			//Integer userId = user.getUserId();
			result = loginMessageService.ipMessage(user.getUserId(),userIp);
			//下面获取服务器的ip地址
			InetAddress inetAddress;
			try {
				inetAddress = InetAddress.getLocalHost();
				hostIp = inetAddress.getHostAddress().toString();
			} catch (UnknownHostException e) {
				System.out.println("获取服务器ip异常");
				e.printStackTrace();
			}
		}else{
			hasSession = "userSessionNull";
		}
		// refreshFlag = loginMessageService.getLoginMessage(user.getUserId(), userIp);
		return SUCCESS;
	}

	@JSON(serialize = false)
	public LoginMessageService getLoginMessageService() {
		return loginMessageService;
	}

	public void setLoginMessageService(LoginMessageService loginMessageService) {
		this.loginMessageService = loginMessageService;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public static String getResult() {
		return result;
	}

	public static void setResult(String result) {
		TipAjaxAction.result = result;
	}

	public String getHasSession() {
		return hasSession;
	}

	public void setHasSession(String hasSession) {
		this.hasSession = hasSession;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

}
