package com.oa.tools.login;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class CreateTree {
	private List<?> list;
	private List<Object> outerList;
	private Class<?> c;
	private Method getIdMethod;
	private Method getParentMethod;
	private Method getChildMethod;
	
	public   List<Object> getTree(List<?> list,Object obj,String getId,String getParent,String getChild){
		int id;
		int parent;
		int child;
		if( outerList != null){
			outerList.clear();
		}else{
			outerList = new ArrayList<Object>();
		}
		this.setList(list);
		this.setC(obj.getClass());
		try {
			getIdMethod = c.getMethod(getId,null);
			getParentMethod = c.getMethod(getParent,null);
			getChildMethod = c.getMethod(getChild,null);
		} catch (NoSuchMethodException e) {
			System.out.println("CreateTree.getTree��������ʱ����NoSuchMethodException********************");
			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println("CreateTree.getTree�ڴ�������ʱ����SecurityException********************");
			e.printStackTrace();
		}
		for(Object o:list){  
			try {
				id = (int)getIdMethod.invoke(o,null);
				parent = (int)getParentMethod.invoke(o,null);
				child = (int)getChildMethod.invoke(o,null);
				if(parent == 0){
					outerList.add(o);
					if(child != 0){
						getChildren(id);
					}
				}
			} catch (IllegalAccessException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����IllegalAccessException********************");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����IllegalArgumentException********************");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����InvocationTargetException********************");
				e.printStackTrace();
			}
		}
		return outerList;
		//5. ����outerLis
		
	}
	
	private void getChildren(int parentId){
		int id;
		int parent;
		int child;
		for(Object o:list){
			try {
				id = (int)getIdMethod.invoke(o,null);
				parent = (int)getParentMethod.invoke(o,null);
				child = (int)getChildMethod.invoke(o,null);
				if(parent == parentId){
					outerList.add(o);
					if(child != 0){
						getChildren(id);
					}
				}
				
			} catch (IllegalAccessException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����IllegalAccessException********************");
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����IllegalArgumentException********************");
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				System.out.println("CreateTree.getTree�ڴ�������ʱ����InvocationTargetException********************");
				e.printStackTrace();
			}
		}
		if("Navigation".equals(c.getName().substring(c.getName().lastIndexOf(".")+1)))
		outerList.add(null);
	}

/*
 * ===============================================================================
 * 				getter()			 setter() 				constroctor()
 * ===============================================================================
 */
	public List<Object> getOuterList() {
		return outerList;
	}

	public void setOuterList(List<Object> outerList) {
		this.outerList = outerList;
	}

	public Class<?> getC() {
		return c;
	}

	public void setC(Class<?> c) {
		this.c = c;
	}

	public Method getGetIdMethod() {
		return getIdMethod;
	}

	public void setGetIdMethod(Method getIdMethod) {
		this.getIdMethod = getIdMethod;
	}

	public Method getGetParentMethod() {
		return getParentMethod;
	}

	public void setGetParentMethod(Method getParentMethod) {
		this.getParentMethod = getParentMethod;
	}

	public Method getGetChildMethod() {
		return getChildMethod;
	}

	public void setGetChildMethod(Method getChildMethod) {
		this.getChildMethod = getChildMethod;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
}

