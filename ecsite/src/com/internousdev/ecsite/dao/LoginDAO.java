package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.dto.ItemDetailDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private LoginDTO loginDTO = new LoginDTO();
	private ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
	private ArrayList<ItemDetailDTO> itemDetailDTOList = new ArrayList<ItemDetailDTO>();

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);
			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				if(resultSet.getBoolean("admin_role")) {
					loginDTO.setAdminRole(true);
					}

				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
					}

				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return loginDTO;
		}


	public LoginDTO getLoginDTO() {
		return loginDTO;
		}


	public ArrayList<ItemDTO> getItemInfo() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction ORDER BY id ASC";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

					while(resultSet.next()){
						ItemDTO dto = new ItemDTO();
						dto.setId(resultSet.getString("id"));
						dto.setItemName(resultSet.getString("item_name"));
						dto.setItemPrice(resultSet.getString("item_price"));
						dto.setItemStock(resultSet.getString("item_stock"));
						itemDTOList.add(dto);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
				return itemDTOList;
			}


	public List<ItemDetailDTO> getItemDetailInfo(){
		 DBConnector dbConnector = new DBConnector();
		 Connection connection = dbConnector.getConnection();
		 List<ItemDetailDTO> itemDetailDTOList = new ArrayList<ItemDetailDTO>();
		 String sql = "SELECT * FROM item_info_transaction";

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				ItemDetailDTO dto = new ItemDetailDTO();
				dto.setId(resultSet.getInt("id"));
//				dto.setItemId(resultSet.getInt("item_id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemDetailDTOList.add(dto);
			}
		}
		catch(SQLException e) {
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemDetailDTOList;
		}


		public ArrayList<ItemDTO> getItemDTOList() {
			return itemDTOList;
		}
		public void setItemDTOList(ArrayList<ItemDTO> itemDTOList) {
			this.itemDTOList = itemDTOList;
		}

		public ArrayList<ItemDetailDTO> getItemDetailDTOList() {
			return itemDetailDTOList;
		}
		public void setItemDetailDTOList(ArrayList<ItemDetailDTO> itemDetailDTOList) {
			this.itemDetailDTOList = itemDetailDTOList;
		}

	}
