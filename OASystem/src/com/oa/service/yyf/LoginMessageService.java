package com.oa.service.yyf;

import com.oa.action.yyf.UserAction;
import com.oa.dao.yyf.LoginMessageDao;


public class LoginMessageService {
	private LoginMessageDao loginMessageDao;

	public String getLoginMessage(Integer userId,String loginIp){
		String ip = loginMessageDao.getLoginMessage(userId);
		if(ip == null){
			return "null";
		}else if(ip.equals(loginIp)){
			return "same";
		}
		return "different";
	}
	
	public String ipMessage(Integer userId,String loginIp){
		
		String lastIp = UserAction.getLastIpMap().get(userId);
		if(lastIp == null || lastIp == ""){
			return "null";
		}else if(loginIp == lastIp || loginIp.equals(lastIp)){
			return "same";
		}else{
			return "different";
		}
	}
	
	public String getLoginIp(Integer userId){
		
		return loginMessageDao.getLoginMessage(userId);
	}

	public LoginMessageDao getLoginMessageDao() {
		return loginMessageDao;
	}

	public void setLoginMessageDao(LoginMessageDao loginMessageDao) {
		this.loginMessageDao = loginMessageDao;
	}
	
	

}
