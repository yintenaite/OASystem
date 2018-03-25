package com.oa.action.yyf;

import java.util.List;

import org.apache.struts2.json.annotations.JSON;

import com.oa.model.Role;
import com.oa.service.yyf.RoleService;
import com.opensymphony.xwork2.ActionSupport;


public class RoleAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Role role;//用于添加角色
	private List<Integer> navId;//用于添加角色,权限id
	private RoleService roleService;
	private String deptId;
	private String roleList;
	
	
	private String needDelId;
	private String needAddId;
	private String roleId;
	private String updateRoleResult;
	
	private String navs;
	private String hasparent;
	private String addRoleResult;
	/**
	 * 获取所有角色
	 * @return String
	 */
	@JSON(serialize = false)
	public String getRolesViaDept(){
		roleList = null;
			roleList = roleService.getRolesViaDept(Integer.parseInt(deptId));
		return SUCCESS;
	}

	/**
	 * 添加一个角色
	 * @return String
	 */
	public String addRole(){ //role,navs,hasparent(yes,no)
		if(role.getRoleName() != null || role.getRoleName() != ""){
			if("no".equals(hasparent)){
				role.setRoleParentId(0);
			}else if(!"yes".equals(hasparent)){
				//失败
				addRoleResult="no";
				return SUCCESS;
			}
			//下面执行调用添加
			roleService.addRole(role, navs.replaceAll(" ",""));
		}else{
			//失败
			addRoleResult="no";
			return SUCCESS;
		}
		addRoleResult="yes";	
		return SUCCESS;
		
		
	}
	
	/**
	 * 删除一个角色
	 * @return String
	 */
	public String delRole(){
		return null;
	}
	
	public String updateRoleAjax(){
		if(needDelId.length() != 0  || needAddId.length() != 0){
			boolean flag=roleService.updateRole(roleId, needDelId, needAddId);
			if(flag){
				updateRoleResult ="success";
			}else{
				updateRoleResult ="error";
			}
		}else{
			updateRoleResult = "success";
		}
		return SUCCESS;
	}
	
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */

	@JSON(serialize = false)
	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	@JSON(serialize = false)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	@JSON(serialize = false)
	public List<Integer> getNavId() {
		return navId;
	}

	public void setNavId(List<Integer> navId) {
		this.navId = navId;
	}
	@JSON(serialize = false)
	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getRoleList() {
		return roleList;
	}

	public void setRoleList(String roleList) {
		this.roleList = roleList;
	}

	public String getNeedDelId() {
		return needDelId;
	}

	public void setNeedDelId(String needDelId) {
		this.needDelId = needDelId;
	}

	public String getNeedAddId() {
		return needAddId;
	}

	public void setNeedAddId(String needAddId) {
		this.needAddId = needAddId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUpdateRoleResult() {
		return updateRoleResult;
	}

	public void setUpdateRoleResult(String updateRoleResult) {
		this.updateRoleResult = updateRoleResult;
	}

	public String getHasparent() {
		return hasparent;
	}

	public void setHasparent(String hasparent) {
		this.hasparent = hasparent;
	}

	public String getNavs() {
		return navs;
	}

	public void setNavs(String navs) {
		this.navs = navs;
	}

	public String getAddRoleResult() {
		return addRoleResult;
	}

	public void setAddRoleResult(String addRoleResult) {
		this.addRoleResult = addRoleResult;
	}
	
}
