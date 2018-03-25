package com.oa.action.yyf;

import java.util.List;

import com.oa.model.Department;
import com.oa.service.yyf.DepartmentService;
import com.opensymphony.xwork2.ActionSupport;

public class DepartmentAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Department> deptList;
	private Integer[] count ;
	private DepartmentService departmentService;

	/**
	 * 
	 * @return List<Department>
	 */
	public String initDept(){
		deptList = null;
		deptList = departmentService.initDept();
		count = new Integer[deptList.size()];
		for(int i = 0;i<deptList.size();i++){
			deptList.get(i).setDeptStaffCount(departmentService.getCountViaDept(deptList.get(i).getDeptId()));
		}
		return SUCCESS;
	}
/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public Integer[] getCount() {
		return count;
	}
	public void setCount(Integer[] count) {
		this.count = count;
	}
}
