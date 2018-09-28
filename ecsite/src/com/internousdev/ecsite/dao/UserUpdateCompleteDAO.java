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

	//ここからupdate文
	public int userDetailUpdate(String id, String loginUserId, String loginPass, String userName) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE login_user_transaction SET login_id=?, login_pass=?, user_name=?, updated_date=? WHERE id=?";
		int result =0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPass);
			preparedStatement.setString(3, userName);
			preparedStatement.setString(4, dateUtil.getDate());
			preparedStatement.setString(5, id);
			result = preparedStatement.executeUpdate();
		}catch  (SQLException e){
				e.printStackTrace();
		} finally {
			connection.close();
		}
			return result;
		}

}
