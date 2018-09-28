package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserDetailDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailDAO {

	public List<UserDetailDTO> getUserDetailInfo(){
		DBConnector dbConnector = new DBConnector();
		 Connection connection = dbConnector.getConnection();
		 List<UserDetailDTO> userDetailDTOList = new ArrayList<UserDetailDTO>();
		 String sql = "SELECT * FROM login_user_transaction";

		 try{
			 PreparedStatement preparedStatement = connection.prepareStatement(sql);
			 ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					UserDetailDTO dto = new UserDetailDTO();
					dto.setId(resultSet.getInt("id"));
					dto.setLoginUserId(resultSet.getString("login_id"));
					dto.setLoginPass(resultSet.getString("login_pass"));
					dto.setUserName(resultSet.getString("user_name"));
					dto.setUpdatedDate(resultSet.getString("updated_date"));
					userDetailDTOList.add(dto);
				}
		 	}
			catch(SQLException e) {
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				return userDetailDTOList;
			}


	//ここからselect文
	public UserDetailDTO getUserDetail(String id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserDetailDTO userDetailDTO = new UserDetailDTO();
		String sql = "select * from login_user_transaction where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userDetailDTO.setId(resultSet.getInt("id"));
				userDetailDTO.setLoginUserId(resultSet.getString("login_id"));
				userDetailDTO.setLoginPass(resultSet.getString("login_pass"));
				userDetailDTO.setUserName(resultSet.getString("user_name"));
				userDetailDTO.setUpdatedDate(resultSet.getString("updated_date"));
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}try {
				connection.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return userDetailDTO;
		}

	//ここからdelete文
	public int userDtailDelete(String id) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "DELETE FROM login_user_transaction WHERE id = ?";
		int result =0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
		}catch  (SQLException e){
				e.printStackTrace();
		}finally {
				connection.close();
		}
			return result;
		}

	}

