package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class CreateProductCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateutil = new DateUtil();
	private String sql = "INSERT INTO product_info (id, product_id, product_name, product_name_kana, product_description, category_id, price, image_file_path, image_file_name, release_date, release_company, regist_date) VALUES(?, ?, ? ,?, ?, ?, ? ,?, ?, ?, ?, ?)";

	public void createProduct(String id, String productId, String productName, String productNameKana, String productDescription,
			String categoryId, String price, String imageFilePath, String imageFileName, String releaseDate, String releaseCompany) throws SQLException {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			preparedStatement.setString(2, productId);
			preparedStatement.setString(3, productName);
			preparedStatement.setString(4, productNameKana);
			preparedStatement.setString(5, productDescription);
			preparedStatement.setString(6, categoryId);
			preparedStatement.setString(7, price);
			preparedStatement.setString(8, imageFilePath);
			preparedStatement.setString(9, imageFileName);
			preparedStatement.setString(10, releaseDate);
			preparedStatement.setString(11, releaseCompany);
			preparedStatement.setString(12, dateutil.getDate());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
