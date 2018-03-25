package com.oa.action.yyf;

import java.util.List;

import com.google.gson.Gson;
import com.oa.model.Navigation;
import com.oa.model.User;
import com.oa.service.yyf.NavigationService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class NavigationAction extends ActionSupport{
	private static final long serialVersionUID = -1247278966637077879L;
	private List<Navigation> navList;//权限集合
	private NavigationService navigationService;
	private static String isAccess="false";
	
	private String roleId;
	private String navListViaJson;
	private String navFlage;
	/**
	 * 通过用户id查询用户拥有的所有权限
	 * @return
	 */
	public String getAllNav(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user != null){
			navList=navigationService.getAllNav(user.getRole().getRoleId().toString());
			return SUCCESS;
		}
		return ERROR;
	}
	
	public String roleNavMenu(){
		navListViaJson=null;
		List<Navigation> navList = navigationService.getAllNav(roleId);
		Gson gson = new Gson();
		if("select".equals(navFlage)){
			String json="";
			if(navList != null){
				int size= navList.size();
				int commas = size;
				for(int i=0;i<size;i++){
					if(navList.get(i) != null){ 
						json +=navList.get(i).getNavId();
						if(i < commas && size !=2) json +=",";
					}else{
						commas--;
					}
				}
				navListViaJson = json;
				System.out.println(navListViaJson);
				
			}
		}else{
			navListViaJson = gson.toJson(navList);
		}
		roleId="all";
		navFlage=null;
		return SUCCESS;
	}

/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public NavigationService getNavigationService() {
		return navigationService;
	}

	public void setNavigationService(NavigationService navigationService) {
		this.navigationService = navigationService;
	}

	public List<Navigation> getNavList() {
		return navList;
	}

	public void setNavList(List<Navigation> navList) {
		this.navList = navList;
	}

	public static String getIsAccess() {
		return isAccess;
	}

	public static void setIsAccess(String isAccess) {
		NavigationAction.isAccess = isAccess;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getNavListViaJson() {
		return navListViaJson;
	}

	public void setNavListViaJson(String navListViaJson) {
		this.navListViaJson = navListViaJson;
	}

	public String getNavFlage() {
		return navFlage;
	}

	public void setNavFlage(String navFlage) {
		this.navFlage = navFlage;
	}
	
}
