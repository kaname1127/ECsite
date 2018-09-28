package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UserDetailDAO;
import com.internousdev.ecsite.dto.UserDetailDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserDetailAction extends ActionSupport implements SessionAware {
	private String id;
	private String message;
	private String deleteFlg;
	private List<UserDetailDTO> userDetailDTOList = new ArrayList<UserDetailDTO>();
	private UserDetailDAO userDetailDAO = new UserDetailDAO();
	public Map<String, Object> session;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		if (deleteFlg == null) {
			UserDetailDAO userDetailDAO = new UserDetailDAO();
			UserDetailDTO userDetailDTO = new UserDetailDTO();
			userDetailDTO = userDetailDAO.getUserDetail(id);
			session.put("id", userDetailDTO.getId());
			session.put("loginUserId", userDetailDTO.getLoginUserId());
			session.put("loginPass", userDetailDTO.getLoginPass());
			session.put("userName", userDetailDTO.getUserName());
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
			userDetailDTOList = null;
			setMessage("商品情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました");
		}
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<UserDetailDTO> getUserDetailDTOList() {
		return userDetailDTOList;
	}

	public void setUserDetailDTOList(List<UserDetailDTO> userDetailDTOList) {
		this.userDetailDTOList = userDetailDTOList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public UserDetailDAO getUserDetailDAO() {
		return userDetailDAO;
	}

	public void setUserDetailDAO(UserDetailDAO userDetailDAO) {
		this.userDetailDAO = userDetailDAO;
	}
}
