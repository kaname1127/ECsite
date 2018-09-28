package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.NewUserCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class NewUserCompleteAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;
	private Map<String, Object> session;
	private NewUserCompleteDAO newUserCompleteDAO = new NewUserCompleteDAO();

	public String execute() throws SQLException {
		NewUserCompleteDAO newUserCompleteDAO = new NewUserCompleteDAO();
		// 性別を0（男性）に初期化
		sex = "0";
		// セッションで取ってきた値が「女性」であれば、sexを「0」で返す
		if (session.get("sex").toString().equals("女性")) {
			sex = "1";
		} else {
			sex = "0";
		}
		// sexのみ上のif文でセッションの値を変換しているため、「sex」でok
		newUserCompleteDAO.newUserCreate(session.get("loginId").toString(), session.get("password").toString(),
				session.get("familyName").toString(), session.get("firstName").toString(),
				session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), sex,
				session.get("email").toString());

		String result = SUCCESS;
		return result;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public NewUserCompleteDAO getNewUserCompleteDAO() {
		return newUserCompleteDAO;
	}

	public void setNewUserCompleteDAO(NewUserCompleteDAO newUserCompleteDAO) {
		this.newUserCompleteDAO = newUserCompleteDAO;
	}

}
