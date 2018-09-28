package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.ProductUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateCompleteAction extends ActionSupport implements SessionAware {

	private String id;
	private String price;
	private String productDescription;
	private String updateMessage;
	public Map<String, Object> session;
	private ProductUpdateCompleteDAO productUpdateCompleteDAO = new ProductUpdateCompleteDAO();

	public String execute() throws SQLException {
		productUpdateCompleteDAO.productDetailUpdate(id, price, productDescription);

		String result = SUCCESS;
		return result;
	}

	public void update() throws SQLException {
		String price = session.get("price").toString();
		String productDescription = session.get("productDescription").toString();
		int res = productUpdateCompleteDAO.productDetailUpdate(id, price, productDescription);
		if (res > 0) {
			setUpdateMessage("商品の値段を正しく更新しました");
		} else {
			setUpdateMessage("商品の値段の更新に失敗しました");
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getUpdateMessage() {
		return updateMessage;
	}

	public void setUpdateMessage(String updateMessage) {
		this.updateMessage = updateMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ProductUpdateCompleteDAO getProductUpdateCompleteDAO() {
		return productUpdateCompleteDAO;
	}

	public void setProductUpdateCompleteDAO(ProductUpdateCompleteDAO productUpdateCompleteDAO) {
		this.productUpdateCompleteDAO = productUpdateCompleteDAO;
	}

}
