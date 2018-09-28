package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemUpdateCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String itemPrice;
	private String itemStock;
	private String updateMessage;
	public Map<String, Object> session;
	private ItemUpdateCompleteDAO itemUpdateCompleteDAO = new ItemUpdateCompleteDAO();

	// String id, String itemPrice, String itemStock
	public String execute() throws SQLException {
		itemUpdateCompleteDAO.itemDetailUpdate(id, itemPrice, itemStock);

		String result = SUCCESS;
		return result;
	}

	public void update() throws SQLException {
		String itemPrice = session.get("item_price").toString();
		String itemStock = session.get("item_stock").toString();
		int res = itemUpdateCompleteDAO.itemDetailUpdate(id, itemPrice, itemStock);
		if (res > 0) {
			setUpdateMessage("商品の値段を正しく更新しました");
		} else {
			setUpdateMessage("商品の値段の更新に失敗しました");
		}
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public ItemUpdateCompleteDAO getItemUpdateCompleteDAO() {
		return itemUpdateCompleteDAO;
	}

	public void setItemUpdateCompleteDAO(ItemUpdateCompleteDAO itemUpdateCompleteDAO) {
		this.itemUpdateCompleteDAO = itemUpdateCompleteDAO;
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
