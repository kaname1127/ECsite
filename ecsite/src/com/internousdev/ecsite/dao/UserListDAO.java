package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {


	public ArrayList<UserDTO> getUserInfo() throws SQLException {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		ArrayList<UserDTO> userDTOList = new ArrayList<UserDTO>();
		String sql ="SELECT id, login_id, login_pass, user_name FROM login_user_transaction ORDER BY id ASC";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				UserDTO dto = new UserDTO();
				dto.setId(resultSet.getString("id"));
				dto.setLoginUserId(resultSet.getString("login_id"));
				dto.setLoginPassword(resultSet.getString("login_pass"));
				dto.setUserName(resultSet.getString("user_name"));
				userDTOList.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return userDTOList;
	}

	public int userListHistoryDelete() throws SQLException{

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		String sql = "DELETE FROM login_user_transaction WHERE admin_role = false";
		PreparedStatement preparedStatement;
		int result =0;

		try{
			preparedStatement = connection.prepareStatement(sql);
			result = preparedStatement.executeUpdate();
		}catch  (SQLException e){
			e.printStackTrace();
		}finally {
			connection.close();
		}
		return result;
	}
}
