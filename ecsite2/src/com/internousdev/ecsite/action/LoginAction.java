package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CartInfoDAO;
import com.internousdev.ecsite.dao.DestinationInfoDAO;
import com.internousdev.ecsite.dao.MCategoryDAO;
import com.internousdev.ecsite.dao.UserInfoDAO;
import com.internousdev.ecsite.dto.DestinationInfoDTO;
import com.internousdev.ecsite.dto.MCategoryDTO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String id;
	private String categoryId;
	private String loginId;
	private String status;
	private String password;
	private boolean savedLoginId;

	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String> loginIdErrorMessageList = new ArrayList<String>();
	private List<String> passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		if (savedLoginId == true) {
			session.put("id", id);
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
			session.put("status", status); // 管理者用
		} else {
			session.put("savedLoginId", false);
			session.remove("loginId", loginId);
			session.remove("status", status); // 管理者用
		}

		InputChecker inputChecker = new InputChecker();
		loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false,
				false, false);

		if (loginIdErrorMessageList.size() != 0 && passwordErrorMessageList.size() != 0) {
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			session.put("logined", 0);
		}

		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		UserInfoDAO userInfoDao = new UserInfoDAO();
		if (userInfoDao.isExistsUserInfo(loginId, password)) {
			if (userInfoDao.login(loginId, password) > 0) {
				UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);
				session.put("id", userInfoDTO.getId());
				session.put("loginId", userInfoDTO.getUserId());
				session.put("status", userInfoDTO.getStatus()); // 管理者用

				int count = 0;
				CartInfoDAO cartInfoDao = new CartInfoDAO();

				count = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")), loginId);
				if (count > 0) {
					DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
					try {
						List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
						destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
						Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
						if (!(iterator.hasNext())) {
							destinationInfoDtoList = null;
						}
						session.put("destinationInfoDtoList", destinationInfoDtoList);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					result = "settlement";
				} else if (!(count > 0) && userInfoDTO.getStatus() == "1") { // 管理者でログイン用
					result = "MASTER";
				} else {
					result = SUCCESS;
				}
			}
			session.put("logined", 1);
		}
		return result;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
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

	public boolean isSavedLoginId() {
		return savedLoginId;
	}

	public void setSavedLoginId(boolean savedLoginId) {
		this.savedLoginId = savedLoginId;
	}

	public List<String> getLoginIdErrorMessageList() {
		return loginIdErrorMessageList;
	}

	public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
		this.loginIdErrorMessageList = loginIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
