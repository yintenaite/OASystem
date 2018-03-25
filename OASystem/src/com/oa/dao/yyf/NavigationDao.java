package com.oa.dao.yyf;

import java.util.List;

import org.hibernate.SessionFactory;

import com.oa.model.Navigation;


public class NavigationDao {
	private SessionFactory sessionFactory;
	
	
	/**
	 * 通过用户id获取拥有的所有权限
	 * 参数：用户id
	 * @return List<Navigation>
	 */
	@SuppressWarnings("unchecked")
	public List<Navigation> getAllNav(String roleId){
		String sql;
		//sql="SELECT * FROM navigation WHERE n_id IN(SELECT n_id FROM role_nav  WHERE r_id =:roleId )";
		if("all".equals(roleId)){
			sql="SELECT * FROM navigation";
			return sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Navigation.class).list();
		}else{
			try {
				int id = Integer.parseInt(roleId);
				sql="SELECT * FROM navigation WHERE n_id IN(SELECT n_id FROM role_nav  WHERE r_id =:id )";
				return sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Navigation.class).setInteger("id",id).list();
			} catch (Exception e) {
				return null;
			}
		}
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	

}
