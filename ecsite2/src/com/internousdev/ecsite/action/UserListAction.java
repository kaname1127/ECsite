package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private UserInfoDAO userInfoDAO = new UserInfoDAO();
	private ArrayList<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) { // ここでエラーに入る
			return ERROR;
		}

		if (deleteFlg == null) {
			userInfoDTOList = userInfoDAO.getUserInfoAll();

		} else if (deleteFlg.equals("1")) {
			delete();
			userInfoDTOList = userInfoDAO.getUserInfoAll();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		int res = userInfoDAO.userListAllDelete();

		if (res > 0) {
			userInfoDTOList = null;
			setMessage("ユーザー情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("ユーザー情報の削除に失敗しました");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserInfoDAO getUserInfoDAO() {
		return userInfoDAO;
	}

	public void setUserInfoDAO(UserInfoDAO userInfoDAO) {
		this.userInfoDAO = userInfoDAO;
	}

	public ArrayList<UserInfoDTO> getUserInfoDTOList() {
		return userInfoDTOList;
	}

	public void setUserInfoDTOList(ArrayList<UserInfoDTO> userInfoDTOList) {
		this.userInfoDTOList = userInfoDTOList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

}
