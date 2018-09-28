package com.internousdev.ecsite.dto;

public class ItemDTO {

	public String id;
	public String itemId;
	public String itemName;
	public String itemPrice;
	public String itemStock;
	public String insertDate;
	public String updateDate;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

//	public String getItemId() {
//		return itemId;
//	}
//	public void setItemId(String itemId) {
//		this.itemId = itemId;
//	}


	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
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
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
}