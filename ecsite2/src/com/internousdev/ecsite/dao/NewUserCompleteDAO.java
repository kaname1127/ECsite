package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class NewUserCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateutil = new DateUtil();
	private String sql = "INSERT INTO user_info (user_id, password, family_name, first_name, family_name_kana, first_name_kana, sex, email, regist_date, update_date) VALUES (?, ?, ? ,?, ?, ?, ?, ?, ?, ?)";

	public void newUserCreate(String loginId, String password, String familyName, String firstName,
			String familyNameKana, String firstNameKana, String sex, String email) throws SQLException {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setString(9, dateutil.getDate());
			preparedStatement.setString(10, dateutil.getDate());
			preparedStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
}