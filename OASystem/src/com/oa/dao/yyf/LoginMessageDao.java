package com.oa.dao.yyf;

import org.hibernate.SessionFactory;


public class LoginMessageDao {
	private SessionFactory sessionFactory;
	
	public String getLoginMessage(Integer userId){
		String sql = "SELECT lm_ip FROM loginmessage WHERE lm_userid =:userId";
		return (String)sessionFactory.getCurrentSession().createSQLQuery(sql).setInteger("userId", userId).uniqueResult();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
}
