package com.oa.service.yyf;

import java.util.List;

import com.oa.dao.yyf.DepartmentDao;
import com.oa.model.Department;


public class DepartmentService {
	private DepartmentDao departmentDao;

	/**
	 * 查询父id与传入id相符的部门
	 * @return List<Department>
	 */
	public List<Department> initDept(){
		return departmentDao.initDept();
	}
	
	public Integer getCountViaDept(Integer deptId){
		
		 try {
			int count = departmentDao.getCountViaDept(deptId);
			return count;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public DepartmentDao getDepartmentDao() {
		return departmentDao;
	}

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	
}
