package com.oa.tools.login;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.oa.action.yyf.NavigationAction;
import com.oa.action.yyf.TipAjaxAction;
import com.oa.action.yyf.UserAction;
import com.oa.model.User;

 
@ServerEndpoint(value = "/loginWebsocket",configurator=GetHttpSessionConfigurator.class)
public class LoginWebSocket {
	private static Map<Integer, LoginWebSocket> sessionMap = new HashMap<Integer,LoginWebSocket>();
	private Session session;
	private HttpSession httpSession;
	private UserAction userAction;
	private static boolean flag = true;
  @OnMessage
  public void onMessage(String m,Session session) throws IOException{
	  System.out.println("onMessage is working");
	  String result = TipAjaxAction.getResult();
	  System.out.println("传入的result为："+result);
	  String isAccess = NavigationAction.getIsAccess(); //是否是从登陆页面过来的
		  this.session = session;
		  if(httpSession != null){
		    	  User user = (User) httpSession.getAttribute("user");
		    	  if(user != null){
		    	    Integer userId = user.getUserId();
		    	    if(sessionMap.get(user.getUserId()) != null){
		    	    	System.out.println("用户登陆发现已有人登,删除登陆信息,session里的用户id为"+user.getUserLoginName());
		    	    	sendLogout(userId,isAccess,result);
		    	    }else{
		    	    	 sessionMap.put(user.getUserId(), this);
		    	    	 System.out.println("用户第一次登陆,session里的用户id为"+user.getUserLoginName());
		    	    	 System.out.println("是否从登陆页面跳转："+NavigationAction.getIsAccess());
		    	    	 NavigationAction.setIsAccess("false");
		    	    	 System.out.println("修改登录页面标志为"+NavigationAction.getIsAccess());
		    	    }
		    }else{
		    	this.getSession().getBasicRemote().sendText("noSession");
		    }
		  }else{
			  this.getSession().getBasicRemote().sendText("noSession");
		  }
	   
  }
 
 /**
   * 强迫下线操作
   * @param userId
 */
public void sendLogout(Integer userId,String isAccess,String result){
	  LoginWebSocket loginWebSocket=null;
	  loginWebSocket = sessionMap.get(userId);
	  System.out.println("本次用户的webSockId="+this.getSession().getId());
	  System.out.println("上一位用户的webSockId="+loginWebSocket.getSession().getId());
	  //删除sessionMap里的session
	  String id = loginWebSocket.getSession().getId();
	  sessionMap.remove(userId);
	  sessionMap.put(userId, this);
	  flag = false;
	  System.out.println("此用户第一次登陆："+isAccess);
	  System.out.println("登陆表有没有此用户："+result); 
	  
	  	//result : null  没有此账号信息
		//		   same	 与此账号信息相同
		//		   different  与此账号信息不同（异地登陆）
		//		   userSessionNull session无user值（session过期）
		  if("true".equals(isAccess) || isAccess == "true"){//true代表用户从登陆页面跳转到主页,或者点击后退按钮又点击前进按钮
			  if(result == "different" || "different".equals(result)){
				  try {
						System.out.println("提示上一位用户下线");
						NavigationAction.setIsAccess("false");//此用户已登陆过，再执行这个页面就是刷新
						userAction.getLastIpMap().remove(userId);
						loginWebSocket.getSession().getBasicRemote().sendText("您的账号被异地登陆，请重新登录");
					} catch (IOException e) {
						System.out.println("io异常");
						e.printStackTrace();
					}
			  }
		  	}else{
		  		if(result == "different" || "different".equals(result)){
			  		try {
						this.getSession().getBasicRemote().sendText("您的账号被异地登陆，请重新登录aaaa");
					} catch (IOException e) {
						System.out.println("io异常");
						e.printStackTrace();
					}
			  	}
		  	}
  }
   
/**
 * session注销操作
 * @param userId
 */
public static void sessionOut(Integer userId){
	System.out.println("执行了session注销调用的方法，删除sessionMap里的user值，用户id为"+userId);
	if(flag){
		if(sessionMap.get(userId) != null){
			System.out.println("删除了sessionMap里面的user--websocket");
			sessionMap.remove(userId);
		}
	}
	flag =true;
}
  @OnOpen
  public void onOpen( EndpointConfig config) {
	  System.out.println("--------------------------------------------------------------");
	  System.out.println("Connection open");
	  System.out.println("--------------------------------------------------------------");
	  this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
  }
 
  @OnClose
  public void onClose() {
	  System.out.println("Connection closed  对象为："+this.getSession().getId());
	//  httpSession.removeAttribute("user");
	//  System.out.println("删除session中的user");
    
  }
  @OnError
  public void onError(Session session, Throwable error){
      System.out.println("发生错误onError");
      error.printStackTrace();
  }
  
  /*
   * ===============================================================================
   * 				getter()			 setter() 				constroctor()
   * ===============================================================================
   */
public Session getSession() {
	return session;
}
public void setSession(Session session) {
	this.session = session;
}

public HttpSession getHttpSession() {
	return httpSession;
}
public void setHttpSession(HttpSession httpSession) {
	this.httpSession = httpSession;
}


public static Map<Integer, LoginWebSocket> getSessionMap() {
	return sessionMap;
}

public static void setSessionMap(Map<Integer, LoginWebSocket> sessionMap) {
	LoginWebSocket.sessionMap = sessionMap;
}

public static void setSessionMap(
		ConcurrentHashMap<Integer, LoginWebSocket> sessionMap) {
	LoginWebSocket.sessionMap = sessionMap;
}

public static boolean isFlag() {
	return flag;
}

public static void setFlag(boolean flag) {
	LoginWebSocket.flag = flag;
}

public UserAction getUserAction() {
	return userAction;
}

public void setUserAction(UserAction userAction) {
	this.userAction = userAction;
}
  
}