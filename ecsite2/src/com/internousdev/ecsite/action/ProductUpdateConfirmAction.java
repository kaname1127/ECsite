package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateConfirmAction extends ActionSupport implements SessionAware {

	private String id;
	private String price;
	private String productDescription;
	public Map<String, Object> session;
	private String errorMessage;

	public String execute() {
		String result = SUCCESS;

		if (!(price.equals(""))) {
			session.put("id", id);
			session.put("price", price);
			session.put("productDescription", productDescription);
		} else {
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
