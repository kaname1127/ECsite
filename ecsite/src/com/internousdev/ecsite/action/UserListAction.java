package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport implements SessionAware {
	public Map<String, Object> session;
	private UserListDAO userListDAO = new UserListDAO();
	private ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		if (deleteFlg == null) {
			userDTOList = userListDAO.getUserInfo();

		} else if (deleteFlg.equals("1")) {
			delete();
			userDTOList = userListDAO.getUserInfo();
		}

		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		int res = userListDAO.userListHistoryDelete();

		if (res > 0) {
			userDTOList = null;
			setMessage("ユーザー情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("ユーザー情報の削除に失敗しました");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public UserListDAO getUserListDAO() {
		return userListDAO;
	}

	public void setUserListDAO(UserListDAO userListDAO) {
		this.userListDAO = userListDAO;
	}

	public ArrayList<UserDTO> getUserDTOList() {
		return userDTOList;
	}

	public void setUserDTOList(ArrayList<UserDTO> userDTOList) {
		this.userDTOList = userDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
