package com.oa.action.yyf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.oa.model.LoginMessage;
import com.oa.model.User;
import com.oa.model.UserProfile;
import com.oa.service.yyf.LoginMessageService;
import com.oa.service.yyf.UserService;
import com.oa.tools.login.IpUtil;
import com.oa.tools.login.LoginWebSocket;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	private UserService userService;
	private LoginMessageService loginMessageService;
	private LoginWebSocket loginWebSocket;
	
	private List<User> userList;
	private User user;
	private String result;
	private String loginName;
	private String loginPassword;
	private String showUserId;
	private UserProfile showUserProfile;
	
	private Integer deptId;
	private String userViaDept; 
	private User addUser;
	private String s;
	//private static String lastIp;
	private static Map<Integer,String> lastIpMap =new HashMap<Integer,String>();
	/**
	 * 获取全部员工信息,首先获取员工的信息,然后获取用户-角色表  
	 * @return String
	 */
	@JSON(serialize = false)
	public String getAllUsers(){
		userList = userService.getAllUsers();
		return SUCCESS;
	}
	
	/**
	 * 用户登录操作
	 * @return String
	 */
	public String userLogin(){
		user=userService.userLogin(loginName,loginPassword);
		if(user == null){
			result = "error"; 
		}else{ 
			String ip = IpUtil.getClientId(ServletActionContext.getRequest());
			String flag = loginMessageService.getLoginMessage(user.getUserId(), ip);
			ActionContext context = ActionContext.getContext();
			if("null".equals(flag)){//如果不存在登陆记录
			//	lastIp = "";
				if(lastIpMap.get(user.getUserId()) != null){
					lastIpMap.remove(user.getUserId());
				}
				context.getSession().put("user", user);//添加用户session
				context.getSession().put("loginMessage", new LoginMessage(user.getUserId(),ip));//添加loginMessage的session
				userService.addOrUpdateLoginMessage(user, ip);
				result = "success";
			}else if("same".equals(flag)){//存在相同的登陆记录
				//lastIp = ip;
				if(lastIpMap.get(user.getUserId()) != null){
					lastIpMap.remove(user.getUserId());
				}
				lastIpMap.put(user.getUserId(), ip);
				context.getSession().remove("user");
				context.getSession().remove("loginMessage");
				context.getSession().put("user", user);
				context.getSession().put("loginMessage", new LoginMessage(user.getUserId(),ip));//添加loginMessage的session
				userService.addOrUpdateLoginMessage(user, ip);
				result = "success";
			}else{//其他ip登陆
				result = "hasLogined";
			}
		}
		NavigationAction.setIsAccess("true");
		return SUCCESS;
	}
	
	/**
	 * 用户主动注销
	 * @return String
	 */
	public String userLogout(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		LoginMessage loginMessage = (LoginMessage) ActionContext.getContext().getSession().get("loginMessage");
		if(loginMessage != null){
			ActionContext.getContext().getSession().remove("loginMessage"); //删除登陆信息session
		}
		if(user != null){
			Integer id =user.getUserId();
			ActionContext.getContext().getSession().remove("user");//删除用户session
			LoginWebSocket.sessionOut(user.getUserId());
			String ip = IpUtil.getClientId(ServletActionContext.getRequest());
			userService.delLoginMessage(id, ip);
			/*if(UserAction.getLastIp() == ""){
				String ip = IpUtil.getClientId(ServletActionContext.getRequest());
				userService.delLoginMessage(id, ip);
			}else{
				userService.delLoginMessage(id, UserAction.getLastIp());
			}*/
			
		}
		return SUCCESS;
	}
	
	public String userForceLogout(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		if(user != null){
			Integer id =user.getUserId();
			ActionContext.getContext().getSession().remove("user");//删除用户session
			LoginWebSocket.sessionOut(user.getUserId());
		}
		return SUCCESS;
	}
	/**
	 * 强制登陆
	 * @return
	 */
	public String forceLogin(){
		user=userService.userLogin(loginName,loginPassword);
		String ip = IpUtil.getClientId(ServletActionContext.getRequest());
		//获取上一位用户的ip
		String lastIp = loginMessageService.getLoginIp(user.getUserId());
		if(lastIpMap.get(user.getUserId()) != null){
			lastIpMap.remove(user.getUserId());
		}
		lastIpMap.put(user.getUserId(),lastIp);
		ActionContext context = ActionContext.getContext();
		context.getSession().remove("user");
		context.getSession().remove("loginMessage");
		context.getSession().put("user", user);
		context.getSession().put("loginMessage", new LoginMessage(user.getUserId(),ip));
		userService.addOrUpdateLoginMessage(user, ip);
		result = "forceLoginSuccess";
		return SUCCESS;
	}
	
/*	*//**
	 * 查看登陆信息表是否有此用户
	 * @param userId
	 * @param ip
	 * @return
	 *//*
	public String getLoginMessage(Integer userId,String ip){
		String s = loginMessageService.getLoginMessage(userId, ip);
		return  s;
	}*/
	
	public String showUserById(){
		showUserProfile = null;
		showUserProfile = userService.showUserById(Integer.parseInt(showUserId)).getUserProfile();
		return SUCCESS;
	}
	
	/**
	 * 查询部门中的用户
	 * 输入参数：部门id： deptId
	 * 输出参数：用户列表：deptUsers
	 * @return
	 */
	@JSON(serialize = false)
	public String getUserByDept(){
		userViaDept = "";
		userViaDept =  userService.getUserByDept(deptId);
		return SUCCESS;
	}
	@JSON(serialize = false)
	public String addUserSave(){
		userService.addUserSave(addUser);
		return SUCCESS;
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	@JSON(serialize = false)
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@JSON(serialize = false)
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	@JSON(serialize = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize = false)
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@JSON(serialize = false)
	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	@JSON(serialize = false)
	public LoginMessageService getLoginMessageService() {
		return loginMessageService;
	}

	public void setLoginMessageService(LoginMessageService loginMessageService) {
		this.loginMessageService = loginMessageService;
	}
	@JSON(serialize = false)
	public LoginWebSocket getLoginWebSocket() {
		return loginWebSocket;
	}

	public void setLoginWebSocket(LoginWebSocket loginWebSocket) {
		this.loginWebSocket = loginWebSocket;
	}
	@JSON(serialize = false)
	public static Map<Integer, String> getLastIpMap() {
		return lastIpMap;
	}

	public static void setLastIpMap(Map<Integer, String> lastIpMap) {
		UserAction.lastIpMap = lastIpMap;
	}
	@JSON(serialize = false)
	public String getShowUserId() {
		return showUserId;
	}

	public void setShowUserId(String showUserId) {
		this.showUserId = showUserId;
	}
	
	public UserProfile getShowUserProfile() {
		return showUserProfile;
	}

	public void setShowUserProfile(UserProfile showUserProfile) {
		this.showUserProfile = showUserProfile;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getUserViaDept() {
		return userViaDept;
	}

	public void setUserViaDept(String userViaDept) {
		this.userViaDept = userViaDept;
	}

	public User getAddUser() {
		return addUser;
	}

	public void setAddUser(User addUser) {
		this.addUser = addUser;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
