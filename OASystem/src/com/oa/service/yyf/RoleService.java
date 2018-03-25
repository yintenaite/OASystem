package com.oa.service.yyf;

import java.util.ArrayList;
import java.util.List;

import com.oa.dao.yyf.RoleDao;
import com.oa.model.Navigation;
import com.oa.model.Role;
import com.oa.model.Role_Nav;
import com.oa.tools.login.CreateTree;



public class RoleService {
	private RoleDao roleDao;
	private CreateTree createTree;
	
	/**
	 * 获取所有角色
	 * @return String
	 */
	public String getRolesViaDept(Integer deptId){
		List<Role> list = roleDao.getRolesViaDept(deptId);
		if(list != null && list.size() !=0){
			String getId = "getRoleId";
			String getParent = "getRoleParentId";
			String getChild = "getRoleChildId";
			List<Object> l = createTree.getTree(list, new Role(), getId, getParent, getChild);
			list.clear();
			for(Object o:l){
				list.add((Role)o);
			}
			String s= "[ "; 
			for(int i=0;i<list.size();i++){
				Integer roleCount = roleDao.getpeopleCount(list.get(i).getRoleId());
				s += "{'roleId':"+list.get(i).getRoleId()+",'roleName':'"+list.get(i).getRoleName()+"','roleCount':"+roleCount+"}";
				if(i<list.size()-1) s += ",";
			}
			s +=" ]";
			System.out.println(s);
			return s; 
		}
		return null;
	}

	/**
	 * 添加一个角色
	 * @return String
	 */
	public boolean addRole(Role role,String navId){
		try {
			roleDao.addRole(role,navId);
		} catch (Exception e) {
			System.out.println("com.service.RoleService.addRole方法报错");
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateRole(String roleId,String del,String add){
		try {
			roleDao.updateRole(roleId, del, add);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	public CreateTree getCreateTree() {
		return createTree;
	}
	public void setCreateTree(CreateTree createTree) {
		this.createTree = createTree;
	}

	
	
}
