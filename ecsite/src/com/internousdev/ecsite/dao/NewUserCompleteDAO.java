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
	private String sql = "INSERT INTO login_user_transaction (login_id, login_pass, user_name,admin_role,insert_date) VALUES(?, ?, ? ,?, ?)";

	public void newUserCerate(String loginUserId, String loginUserPassword, String userName) throws SQLException {

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginUserPassword);
			preparedStatement.setString(3, userName);
			preparedStatement.setBoolean(4, false);
			preparedStatement.setString(5, dateutil.getDate());
			preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
		connection.close();
		}
	}
}
