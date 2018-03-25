package com.oa.dao.yyf;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.SessionFactory;

import com.oa.model.Department;


public class DepartmentDao {
	private SessionFactory sessionFactory;

	
	/**
	 * 查询父id与传入id相符的部门
	 * @return List<Department>
	 */
	public List<Department> initDept(){
		String sql="select * from department";
		return sessionFactory.getCurrentSession().createSQLQuery(sql).addEntity(Department.class).list();
	}
	
	public Integer getCountViaDept(Integer deptId){
		String sql = "select count(*) from `user` WHERE d_id = :deptId";
		 String result = sessionFactory.getCurrentSession().createSQLQuery(sql).setInteger("deptId", deptId).uniqueResult().toString();
		 return Integer.parseInt(result);
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
