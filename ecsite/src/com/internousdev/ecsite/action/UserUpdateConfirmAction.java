package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private String loginUserId;
	private String loginPass;
	private String userName;
	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;

		if (!(loginUserId.equals("")) && !(loginPass.equals("")) && !(userName.equals(""))) {
			session.put("loginUserId", loginUserId);
			session.put("loginPass", loginPass);
			session.put("userName", userName);
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
