package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {

		private DBConnector dbConnector = new DBConnector();
		private Connection connection = dbConnector.getConnection();
//		private BuyItemDTO buyItemDTO = new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo() throws SQLException {
		BuyItemDTO dto = new BuyItemDTO();
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction ORDER BY id ASC";

			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();

					if(resultSet.next()){
						dto.setId(resultSet.getInt("id"));
						dto.setItemName(resultSet.getString("item_name"));
						dto.setItemPrice(resultSet.getString("item_price"));
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
				return dto ;
			}



//	public ArrayList<BuyItemDTO> getBuyItemInfo2() throws SQLException {
//		ArrayList<BuyItemDTO> buyItemDTOList = new ArrayList<BuyItemDTO>();
//		String sql = "SELECT id, item_name, item_price FROM item_info_transaction ORDER BY insert_date DESC";
//
//			try {
//				PreparedStatement preparedStatement = connection.prepareStatement(sql);
//				ResultSet resultSet = preparedStatement.executeQuery();
//
//					while(resultSet.next()){
//						BuyItemDTO dto = new BuyItemDTO();
//						dto.setId(resultSet.getInt("id"));
//						dto.setItemName(resultSet.getString("item_name"));
//						dto.setItemPrice(resultSet.getString("item_price"));
//						buyItemDTOList.add(dto);
//				}
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//				return buyItemDTOList ;
//			}
//
//			public BuyItemDTO getBuyItemDTO() {
//				return buyItemDTO;
//			}
	}