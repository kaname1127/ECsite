package com.internousdev.ecsite.dto;

public class UserDetailDTO {
  private int id;
  private String loginUserId;
  private String loginPass;
  private String userName;
  private String updatedDate;


	public int getId() {
		return id;
	}
	public void setId(int id) {
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

	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

}
