package com.internousdev.ecsite.action;

import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateProductConfirmAction extends ActionSupport implements SessionAware {
	private String id;
	private String productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private String categoryId;
	private String price;
	private String imageFilePath;
	private String imageFileName;
	private Date releaseDate;
	private String releaseCompany;
	private String errorMessage;
	public Map<String, Object> session;

	public String execute() {
		String result = SUCCESS;

		if (!(productId.equals("")) && !(productName.equals("")) && !(productNameKana.equals(""))
				&& !(productDescription.equals("")) && !(categoryId.equals("")) && !(price.equals(""))
				&& !(imageFilePath.equals("")) && !(imageFileName.equals("")) && !(releaseDate.equals(""))
				&& !(releaseCompany.equals(""))) {
			session.put("productId", productId);
			session.put("productName", productName);
			session.put("productNameKana", productNameKana);
			session.put("productDescription", productDescription);
			session.put("categoryId", categoryId);
			session.put("price", price);
			session.put("imageFilePath", imageFilePath);
			session.put("imageFileName", imageFileName);
			session.put("releaseDate", releaseDate);
			session.put("releaseCompany", releaseCompany);
			session.put("errorMessage", errorMessage);
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

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
