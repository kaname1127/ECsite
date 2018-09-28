package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class UserUpdateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	// ここからupdate文
	public int userDetailUpdate(String id, String loginId, String password, String familyName, String firstName, String familyNameKana,
			String firstNameKana, String email) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE user_info SET user_id=?, password=?, family_name=?, first_name=?, family_name_kana=?, first_name_kana=?, email=?, update_date=? WHERE id=?";
		int result = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginId);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
//			preparedStatement.setString(7, sex);
			preparedStatement.setString(7, email);
			preparedStatement.setString(8, dateUtil.getDate());
			preparedStatement.setString(9, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
