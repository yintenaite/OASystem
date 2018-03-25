package com.oa.service.yyf;

import java.util.List;

import com.oa.dao.yyf.NavigationDao;
import com.oa.model.Navigation;
import com.oa.tools.login.CreateTree;

public class NavigationService {
	private NavigationDao navigationDao;
	private CreateTree createTree;
	
	/**
	 * 通过用户id获取拥有的所有权限
	 * 参数：用户id
	 * @return List<Navigation>
	 */
	public List<Navigation> getAllNav(String roleId){
		List<Navigation> list=navigationDao.getAllNav(roleId);
		if(list != null && list.size() !=0){
			String getId = "getNavId";
			String getParent = "getNavParentId";
			String getChild = "getNavChildId";
			List<Object> l = createTree.getTree(list, new Navigation(), getId, getParent, getChild);
			list.clear();
			for(Object o:l){
				list.add((Navigation)o);
			}
			return list;
		}
		
		return null;
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public NavigationDao getNavigationDao() {
		return navigationDao;
	}

	public void setNavigationDao(NavigationDao navigationDao) {
		this.navigationDao = navigationDao;
	}

	public CreateTree getCreateTree() {
		return createTree;
	}

	public void setCreateTree(CreateTree createTree) {
		this.createTree = createTree;
	}

	
}
