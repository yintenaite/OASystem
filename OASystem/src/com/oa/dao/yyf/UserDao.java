package com.oa.dao.yyf;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.oa.model.Department;
import com.oa.model.LoginMessage;
import com.oa.model.Role;
import com.oa.model.User;


public class UserDao {
	private SessionFactory sessionFactory;
	
	/**
	 * 获取全部员工信息
	 * @return List<User>
	 */
	public List<User> getAllUsers(){
		String sql="select * from user";
		List<User> list = sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class).list();
		return list;
	}
	/*//根据用户id查他部门的经理
	public User getManagerByUserId(Integer userId){
		String sql = "SELECT * FROM `user` WHERE r_id=("+
				"SELECT r_id FROM role WHERE r_parentid =0 AND d_id=("+
				"SELECT d_id FROM `user` WHERE u_id=:userId))";
		return (User) sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class)
				.setInteger("userId", userId).uniqueResult();
	}*/
	/**
	 * 登陆查询
	 * @param userLoginName
	 * @param userLoginPassword
	 * @return
	 */
	public User userLogin(String userLoginName,String userLoginPassword){
		User user = (User) sessionFactory.getCurrentSession().createCriteria(User.class)
					.add(Restrictions.eq("userLoginName", userLoginName))
					.add(Restrictions.eq("userPassword",userLoginPassword ))
					.uniqueResult();
		return user == null?null:user;
	}

	/**
	 * 添加或修改登录信息
	 * @param loginMessage
	 */
	public void addOrUpdateLoginMessage(LoginMessage loginMessage){
		
		sessionFactory.getCurrentSession().saveOrUpdate(loginMessage);
	}
	
	/**
	 * 删除登录信息
	 * @param loginMessage
	 */
	public void delLoginMessage(LoginMessage loginMessage){
		sessionFactory.getCurrentSession().delete(loginMessage);
	}
	
	public boolean getLoginMessage(int id,String ip){
		String sql = "SELECT COUNT(*) FROM loginmessage WHERE lm_userid = :id AND  lm_ip = :ip";
		if(((Object)sessionFactory.getCurrentSession().createSQLQuery(sql).setInteger("id", id).setString("ip", ip).uniqueResult()) != null){
			return true;
		}
		return false;
	}
	
	public User showUserById(Integer id){
		String sql = "select * from user where u_id=:id";
		return (User) sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class).setInteger("id", id).uniqueResult();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUserByDept(Integer deptId){
		String sql="select * from user where d_id=:deptId";
		List<User> user =(List<User>)sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(User.class).setInteger("deptId", deptId).list();
		return user;
	}
	
	public void addUserSave(User user){
		Session session = sessionFactory.getCurrentSession();
		session.save(user);
		session.flush();
		session.clear();
	
	}
	/** 
	* @Title: findTransactor 
	* @date 2015年9月25日 下午3:57:41 
	* @Description: TODO(动态指定查询部门) 
	* @param @param user
	* @param @return    null 
	* @return User    返回类型 
	* @throws 
	*/
	public Department findDepartment(User user) {
		String hql = "select d from User u,Department d where u.department.deptId = d.deptId and u.userId="+user.getUserId();
		Department department = (Department) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
		if(department!=null){
			return department;
		}else{
			return null;
		}
	}
	/** 
	* @Title: findTransactUser 
	* @date 2015年9月28日 上午8:42:47 
	* @Description: TODO(动态指定请假单办理人) 
	* @param @param department
	* @param @return    设定文件 
	* @return Role    返回类型 
	* @throws 
	*/
	public User findTransactor(User user){
		User u =null;
	/*	String hql = "select d from Department d,User u where u.department.deptId=d.deptId and u.userId="+user.getUserId()+"";
		Department department = (Department) sessionFactory.getCurrentSession().createQuery(hql).list().get(0);
		if(department!=null){
			String hql1 = "select r from Role r where r.department.deptId="+department.getDeptId();
			Role role = (Role) sessionFactory.getCurrentSession().createQuery(hql1).list().get(0);
			if(role.getRoleId()!=user.getRole().getRoleId()){
				String hql2 = "select u from User u where u.role.roleId="+role.getRoleId();
				 User u = (User) sessionFactory.getCurrentSession().createQuery(hql2).list().get(0);
				 return u;
			}else{
				String hq3 = "select u from User u  where u.role.roleParentId=0";
				 User u = (User) sessionFactory.getCurrentSession().createQuery(hq3).list().get(0);
				 return u;
			}
		}else{
			String hq4 = "select u from User u  where u.role.roleParentId=0";
			 User u = (User) sessionFactory.getCurrentSession().createQuery(hq4).list().get(0);
			 return u;
		}*/
		if(user.getRole().getRoleParentId()==0){
			int parentId = user.getRole().getDepartment().getDeptParentId();
			String hql = "select r.roleId from Role r where r.department.deptId="+parentId+" AND r.roleParentId=0";
			int roleId =  (int) sessionFactory.getCurrentSession().createQuery(hql).list().get(0);
			 String hql1 = "select u from User u where u.role.roleId="+roleId;
			  u  = (User) sessionFactory.getCurrentSession().createQuery(hql1).list().get(0);
		}else{
			String hql = "select d from Department d,User u where u.department.deptId=d.deptId and u.userId="+user.getUserId()+"";
			Department department = (Department) sessionFactory.getCurrentSession().createQuery(hql).list().get(0);
			String hql1 = "select r from Role r where r.department.deptId="+department.getDeptId();
			Role role = (Role) sessionFactory.getCurrentSession().createQuery(hql1).list().get(0);
			String hql2 = "select u from User u where u.role.roleId="+role.getRoleId();
			  u = (User) sessionFactory.getCurrentSession().createQuery(hql2).list().get(0);
		}
		return u;
	}
	/** 
	* @Title: findTransactorByUser 
	* @date 2015年10月4日 上午10:50:59 
	* @Description: TODO(动态指定报销单的办理人) 
	* @param @param user
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	public User findTransactorByUser(User user,Double money) {
		User u = null;
		String hql = "select d from Department d,User u where u.department.deptId=d.deptId and u.userId="+user.getUserId()+"";
		Department department = (Department) sessionFactory.getCurrentSession().createQuery(hql).list().get(0);
		String hql2 = "select u.role.roleName from User u where  u.role.roleId="+user.getRole().getRoleId();
		String roleName =  (String) sessionFactory.getCurrentSession().createQuery(hql2).list().get(0);
		if(department!=null){
			String hql1 = "select r from Role r where r.department.deptId="+department.getDeptId();
			Role role = (Role) sessionFactory.getCurrentSession().createQuery(hql1).list().get(0);
			if(role.getRoleId()!=user.getRole().getRoleId()){
				if(roleName.equals("会计")){
					if(money>2000){
					    	String hq5 = "select u from User u  where u.role.roleParentId=0 AND u.department.deptParentId=0";
						  u = (User) sessionFactory.getCurrentSession().createQuery(hq5).list().get(0);
					}else{
						String hq6 = "select u from User u  where u.role.roleName='出纳'";
						 u = (User) sessionFactory.getCurrentSession().createQuery(hq6).list().get(0);
					}
				}
				else{
					String hql6 = "select u from User u  where u.role.roleId="+role.getRoleId();
					  u = (User) sessionFactory.getCurrentSession().createQuery(hql6).list().get(0);
				}
			}else{
				if(roleName.equals("总经理")){
					String hq6 = "select u from User u  where u.role.roleName='出纳'";
					 u = (User) sessionFactory.getCurrentSession().createQuery(hq6).list().get(0);
				}else{
					String hq6 = "select u from User u  where u.role.roleName='会计'";
					 u = (User) sessionFactory.getCurrentSession().createQuery(hq6).list().get(0);
				}
			}
		}else{
			String hq6 = "select u from User u  where u.role.roleName='出纳'";
			 u = (User) sessionFactory.getCurrentSession().createQuery(hq6).list().get(0);
		}
		return u;
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
