package com.oa.dao.yyf;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oa.model.Navigation;
import com.oa.model.Role;
import com.oa.model.Role_Nav;


public class RoleDao {
	private SessionFactory sessionFactory;

	/**
	 * 获取角色
	 * @return String
	 */
	public List<Role> getRolesViaDept(Integer deptId){
		String sql = "select * from role where d_id="+deptId;
		List<Role> l = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Role.class).list();
		 return l;
	}
	public Integer getpeopleCount(Integer roleId){
		String sql = "SELECT * FROM `user` WHERE r_id=:id";
		return  sessionFactory.getCurrentSession().createSQLQuery(sql).setInteger("id", roleId).list().size();
	}
	public void addRole(Role role,String navs){
		sessionFactory.getCurrentSession().save(role);
		int roleId = role.getRoleId();
		if(navs.length() != 0){
			String[] addRole =navs.split(",");
			int length = addRole.length;
			//int roleId = role.getRoleId();
			Session session = sessionFactory.getCurrentSession();
			StringBuffer sql = new StringBuffer("INSERT INTO role_nav (r_id,n_id) VALUES "); 
			for(int i =0; i<length; i++){
				sql.append("(?,?)");
				if(i < length-1) sql.append(",");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			int i,j;
			for(i = 0,j = 0; i<length; i++,j=j+2){
				query.setInteger(j,roleId);
				query.setInteger(j+1,Integer.parseInt(addRole[i]));
			}
			query.executeUpdate();
		}
		
	}
	
	public void updateRole(String roleId,String del,String add){
		String[] updateRole;
		if(del.length() != 0){
			updateRole = del.split(",");
			int delLength = updateRole.length;
			String sql = "delete from role_nav where (";
			for(int i = 0; i < delLength; i++){
				sql += "n_id = ? ";
				if(i<delLength-1){
					sql += " or ";
				}
			}
			sql += ") and r_id =:roleId";
			SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
			for(int i = 0; i < delLength; i++){
				query.setInteger(i, Integer.parseInt(updateRole[i]));
			}
			query.setInteger("roleId", Integer.parseInt(roleId)).executeUpdate();
		}
		if(add.length() != 0){
			updateRole = add.split(",");
			int addLength = updateRole.length;
			Session session = sessionFactory.getCurrentSession();
			/*for(int i =0; i<addLength; i++){
				session.save(new Role_Nav(new Role(Integer.parseInt(roleId)),new Navigation(Integer.parseInt(updateRole[i]))));
			}*/
			StringBuffer sql = new StringBuffer("INSERT INTO role_nav (r_id,n_id) VALUES "); 
			for(int i =0; i<addLength; i++){
				sql.append("(?,?)");
				if(i < addLength-1) sql.append(",");
			}
			SQLQuery query = session.createSQLQuery(sql.toString());
			int i,j;
			for(i = 0,j = 0; i<addLength; i++,j=j+2){
				query.setInteger(j,Integer.parseInt(roleId));
				query.setInteger(j+1,Integer.parseInt(updateRole[i]));
			}
			query.executeUpdate();
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
