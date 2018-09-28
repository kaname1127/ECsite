package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		if (deleteFlg == null) {
			// String item_transaction_id = session.get("id").toString();
			// String item_transaction_item_name =
			// session.get("item_name").toString();
			// String item_transaction_item_price =
			// session.get("item_price").toString();
			// String item_transaction_item_stock =
			// session.get("item_stock").toString();
			itemDTOList = itemListDAO.getItemInfo();
			//
		} else if (deleteFlg.equals("1")) {
			delete();
		}

		String result = SUCCESS;
		return result;
	}

	// DELETE
	public void delete() throws SQLException {
		// String item_transaction_id = session.get("id").toString();
		// String item_transaction_item_name =
		// session.get("itemName").toString();
		// String item_transaction_item_price =
		// session.get("itemPrice").toString();
		// String item_transaction_item_stock =
		// session.get("itemStock").toString();
		int res = itemListDAO.itemListHistoryDelete();
		// (item_transaction_id, item_transaction_item_name,
		// item_transaction_item_price, item_transaction_item_stock);

		if (res > 0) {
			itemDTOList = null;
			setMessage("商品情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました");
		}
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ItemListDAO getItemListDAO() {
		return itemListDAO;
	}

	public void setItemListDAO(ItemListDAO itemListDAO) {
		this.itemListDAO = itemListDAO;
	}

	public ArrayList<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(ArrayList<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
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