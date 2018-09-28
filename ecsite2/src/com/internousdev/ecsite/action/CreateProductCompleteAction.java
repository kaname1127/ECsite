package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.CreateProductCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateProductCompleteAction extends ActionSupport implements SessionAware {

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
	public Map<String, Object> session;
	private CreateProductCompleteDAO createProductCompleteDAO = new CreateProductCompleteDAO();

	public String execute() throws SQLException {
		createProductCompleteDAO.createProduct(session.get("id").toString(), session.get("productId").toString(),
				session.get("productName").toString(), session.get("productNameKana").toString(),
				session.get("productDescription").toString(), session.get("categoryId").toString(),
				session.get("price").toString(), session.get("imageFilePath").toString(),
				session.get("imageFileName").toString(), session.get("releaseDate").toString(),
				session.get("releaseCompany").toString());

		String result = SUCCESS;
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

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public CreateProductCompleteDAO getCreateProductCompleteDAO() {
		return createProductCompleteDAO;
	}

	public void setCreateProductCompleteDAO(CreateProductCompleteDAO createProductCompleteDAO) {
		this.createProductCompleteDAO = createProductCompleteDAO;
	}

}
