package com.internousdev.ecsite.dto;


public class ItemDetailDTO {
	private int id;
//	private int itemId;
	private String itemName;
	private String itemPrice;
	private String itemStock;
	private String insertDate;
//	private int categoryId;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

//	public int getItemId() {
//		return itemId;
//	}
//	public void setItemId(int itemId) {
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
//	public int getCategoryId() {
//		return categoryId;
//	}
//	public void setCategoryId(int categoryId) {
//		this.categoryId = categoryId;
//	}
	public String getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}
}
