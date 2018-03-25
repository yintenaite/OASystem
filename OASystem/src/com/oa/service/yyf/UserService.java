package com.oa.service.yyf;

import java.util.Date;
import java.util.List;
import com.oa.dao.yyf.UserDao;
import com.oa.model.LoginMessage;
import com.oa.model.User;

public class UserService {
	private UserDao userDao;
	/**
	 * 获取全部员工信息
	 * @return List<User>
	 */
	public List<User> getAllUsers(){
		List<User> list;
		try {
			list = userDao.getAllUsers();
		} catch (Exception e) {
			System.out.println("com.service.UserService.getAllUsers()报错");
			e.printStackTrace();
			return  null;
		}
		return list;
	}


	/**
	 * 登陆查询操作
	 * @param user
	 * @return
	 */
	public User userLogin(String loginName,String loginPassword){
		User u;
		try {
			u = userDao.userLogin(loginName, loginPassword);
			if(u == null){
				return null;
			}else{
				return u;
			}
		} catch (Exception e) {
			System.out.println("com.UserService.userLogin报错");
			e.printStackTrace();
			return null;
		}
		
	}

	public void addOrUpdateLoginMessage(User user,String ip){
		try {
			userDao.addOrUpdateLoginMessage(new LoginMessage(user.getUserId(), ip));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("com.service.UserService.addOrUpdateLoginMessage方法报错");
			e.printStackTrace();
		}
	}
	
	/**
	 * 删除登录信息，先查询是否存在
	 */
	public void delLoginMessage(int id,String ip){
		if(userDao.getLoginMessage(id, ip) == true){
			userDao.delLoginMessage(new LoginMessage(id,ip));
		}
		
	}
	
	/**
	 * 根据id查user
	 * @return
	 */
	public User showUserById(Integer id){
		return userDao.showUserById(id);
	}
	
	public String getUserByDept(Integer deptId){
			List<User> users = userDao.getUserByDept(deptId);
			String json="[ ";
			for(int i=0;i<users.size();i++){
				json += "{'userId':"+users.get(i).getUserId()+",'userTrueName':'"+users.get(i).getUserTrueName()+"'}";
				if(i < users.size()-1)
					json +=",";
			}
			json +=" ]";
			return json;
		
	}
	
	public void addUserSave(User user){
		try {
			user.getUserProfile().setUserCreateTime(new Date());
			user.setUserPassword("123456");
			userDao.addUserSave(user);
		} catch (Exception e) {
			System.out.println("UserService.addUserSave报错");
			e.printStackTrace();
		}
	}
	/**
	* @Title: findTransactName 
	* @date 2015年9月25日 下午3:54:14 
	* @Description: TODO(动态指定任务的办理人请假单) 
	* @param @param user    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public User findTransactName(User user) {
		
		return userDao.findTransactor(user);
	}
	

	/** 
	* @Title: findTransactorAccount 
	* @date 2015年10月4日 上午10:49:57 
	* @Description: TODO(动态指定任务的办理人报销单) 
	* @param @param user
	* @param @return    设定文件 
	* @return User    返回类型 
	* @throws 
	*/
	public User findTransactorAccount(User user,Double money) {
		return userDao.findTransactorByUser(user,money);
	}


	
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	
}
