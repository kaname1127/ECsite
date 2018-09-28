package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemAction extends ActionSupport implements SessionAware {

	public Map<String, Object> session;
	private int count;
	private String pay;
	private ItemListDAO itemListDAO = new ItemListDAO();
	private ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();

	public String execute() throws SQLException {
		String result = SUCCESS;
		session.put("count", count);
		int intCount = Integer.parseInt(session.get("count").toString());
		int intPrice = Integer.parseInt(session.get("buyItem_price").toString());
		session.put("total_price", intCount * intPrice);

		String payment;
		if (pay.equals("1")) {
			itemDTOList = itemListDAO.getItemInfo();
			payment = "現金払い";
			session.put("pay", payment);
		} else {
			payment = "クレジットカード";
			session.put("pay", payment);
		}
		return result;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<ItemDTO> getItemDTOList() {
		return itemDTOList;
	}

	public void setItemDTOList(ArrayList<ItemDTO> itemDTOList) {
		this.itemDTOList = itemDTOList;
	}
}
