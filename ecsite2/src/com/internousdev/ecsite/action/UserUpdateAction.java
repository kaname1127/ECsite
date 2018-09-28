package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateAction extends ActionSupport implements SessionAware {
	private UserDetailDAO userDetailDAO = new UserDetailDAO();
	public Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

	public UserDetailDAO getUserDetailDAO() {
		return userDetailDAO;
	}

	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		this.userDetailDAO = userDetailDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
