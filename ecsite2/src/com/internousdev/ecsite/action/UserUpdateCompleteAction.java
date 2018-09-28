package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateCompleteAction extends ActionSupport implements SessionAware {
	private String id;
	private String loginId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private Date registDate;
	private Date updateDate;
	private String updateMessage;

	private UserUpdateCompleteDAO userUpdateCompleteDAO = new UserUpdateCompleteDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		userUpdateCompleteDAO.userDetailUpdate(id, familyName, firstName, familyNameKana, firstNameKana, loginId,
				password, email);

		String result = SUCCESS;
		return result;
	}

	public void update() throws SQLException {
		String id = session.get("id").toString();
		String loginId = session.get("user_id").toString();
		String password = session.get("password").toString();
		String familyName = session.get("family_name").toString();
		String firstName = session.get("first_name").toString();
		String familyNameKana = session.get("family_name_kana").toString();
		String firstNameKana = session.get("first_name_kana").toString();
//		String sex = session.get("sex").toString();
		String email = session.get("email").toString();
		int res = userUpdateCompleteDAO.userDetailUpdate(id, familyName, firstName, familyNameKana, firstNameKana, loginId,
				password, email);
		if (res > 0) {
			setUpdateMessage("ユーザー情報を正しく更新しました");
		} else {
			setUpdateMessage("ユーザー情報の更新に失敗しました");
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(String updateMessage) {
		this.updateMessage = updateMessage;
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

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
