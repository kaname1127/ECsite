package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateAction extends ActionSupport implements SessionAware {

	private ItemDetailDAO itemDetailDAO = new ItemDetailDAO();
	public Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ItemDetailDAO getItemDetailDAO() {
		return itemDetailDAO;
	}

	public void setItemDetailDAO(ItemDetailDAO itemDetailDAO) {
		this.itemDetailDAO = itemDetailDAO;
	}

}
