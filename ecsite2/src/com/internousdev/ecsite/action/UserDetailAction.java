package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport implements SessionAware {
	private String id;
	private String message;
	private String deleteFlg;
	private List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
	private UserDetailDAO userDetailDAO = new UserDetailDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		if (deleteFlg == null) {
			UserDetailDAO userDetailDAO = new UserDetailDAO();
			UserInfoDTO userInfoDTO = new UserInfoDTO();
			userInfoDTO = userDetailDAO.getUserDetail(id);
			session.put("id", userInfoDTO.getId());
			session.put("userId", userInfoDTO.getUserId());
			session.put("password", userInfoDTO.getPassword());
			session.put("familyName", userInfoDTO.getFamilyName());
			session.put("firstName", userInfoDTO.getFirstName());
			session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana", userInfoDTO.getFirstNameKana());
			session.put("sex", userInfoDTO.getSex());
			session.put("email", userInfoDTO.getEmail());
			session.put("registDate", userInfoDTO.getRegistDate());

		} else if (deleteFlg.equals("1")) {
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	// ここからdelete文
	public void delete() throws SQLException {
		String id = session.get("id").toString();
		int res = userDetailDAO.userDtailDelete(id);
		if (res > 0) {
			userInfoDTOList = null;
			setMessage("商品情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public List<UserInfoDTO> getUserInfoDTOList() {
		return userInfoDTOList;
	}

	public void setUserInfoDTOList(List<UserInfoDTO> userInfoDTOList) {
		this.userInfoDTOList = userInfoDTOList;
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
