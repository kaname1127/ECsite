package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String loginUserId;
	private String loginPass;
	private String userName;
	private String updateMessage;
	private UserUpdateCompleteDAO userUpdateCompleteDAO = new UserUpdateCompleteDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		userUpdateCompleteDAO.userDetailUpdate(id, loginUserId, loginPass, userName);

		String result = SUCCESS;
		return result;
	}

	public void update() throws SQLException {
		String loginUserId = session.get("login_id").toString();
		String loginPass = session.get("login_pass").toString();
		String userName = session.get("user_name").toString();
		int res = userUpdateCompleteDAO.userDetailUpdate(id, loginUserId, loginPass, userName);
		if (res > 0) {
			setUpdateMessage("ユーザー情報を正しく更新しました");
		} else {
			setUpdateMessage("ユーザー情報の更新に失敗しました");
		}
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

	public UserUpdateCompleteDAO getUserUpdateCompleteDAO() {
		return userUpdateCompleteDAO;
	}

	public void setUserUpdateCompleteDAO(UserUpdateCompleteDAO userUpdateCompleteDAO) {
		this.userUpdateCompleteDAO = userUpdateCompleteDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(String updateMessage) {
		this.updateMessage = updateMessage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
