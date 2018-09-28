package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserDetailDAO {

	public List<UserInfoDTO> getUserDetail() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();
		String sql = "SELECT * FROM user_info";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				UserInfoDTO dto = new UserInfoDTO();
				dto.setId(resultSet.getInt("id"));
				dto.setUserId(resultSet.getString("user_id"));
				dto.setPassword(resultSet.getString("password"));
				dto.setFamilyName(resultSet.getString("family_name"));
				dto.setFirstName(resultSet.getString("first_name"));
				dto.setFamilyNameKana(resultSet.getString("family_name_kana"));
				dto.setFirstNameKana(resultSet.getString("first_name_kana"));
//				dto.setSex(resultSet.getInt("sex"));
				dto.setEmail(resultSet.getString("email"));
				dto.setRegistDate(resultSet.getDate("regist_date"));
				userInfoDTOList.add(dto);
			}
		} catch (SQLException e) {
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTOList;
	}

	// ここからselect文.idで拾う
	public UserInfoDTO getUserDetail(String id) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql = "select * from user_info where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userInfoDTO.setId(resultSet.getInt("id"));
				userInfoDTO.setUserId(resultSet.getString("user_id"));
				userInfoDTO.setPassword(resultSet.getString("password"));
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
				userInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userInfoDTO;

	}

	// ここからdelete文
	public int userDtailDelete(String id) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "DELETE FROM user_info WHERE id = ?";
		int result = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return result;
	}
}
