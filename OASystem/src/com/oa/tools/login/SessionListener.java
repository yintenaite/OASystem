package com.oa.tools.login;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.oa.model.User;

public class SessionListener implements HttpSessionAttributeListener{
	@Override
	public void attributeAdded(HttpSessionBindingEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent e) {
		// TODO Auto-generated method stub
		if("user".equals(e.getName())){
			User user =(User) e.getValue();
			System.out.println("�û�������"+user.getUserLoginName()+"��session��ɾ��");
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
