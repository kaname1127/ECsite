package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemDetailDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemDetailDAO {

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

	//ここからselect文
		public ItemDetailDTO getItemDetail(String id) {
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			ItemDetailDTO itemDetailDTO = new ItemDetailDTO();
			String sql = "select * from item_info_transaction where id=?";
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, id);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					itemDetailDTO.setId(resultSet.getInt("id"));
	//				itemDetailDTO.setItemId(resultSet.getInt("item_id"));
					itemDetailDTO.setItemName(resultSet.getString("item_name"));
					itemDetailDTO.setItemPrice(resultSet.getString("item_price"));
					itemDetailDTO.setItemStock(resultSet.getString("item_stock"));
					itemDetailDTO.setInsertDate(resultSet.getString("insert_date"));
	//				itemDetailDTO.setItemId(resultSet.getInt("category_id"));
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}try {
					connection.close();
				}catch (SQLException e) {
					e.printStackTrace();
				}
				return itemDetailDTO;
			}



	//ここからdelete文
		public int itemDtailDelete(String id) throws SQLException{
			DBConnector dbConnector = new DBConnector();
			Connection connection = dbConnector.getConnection();
			String sql = "DELETE FROM item_info_transaction WHERE id = ?";
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


//ここからカテゴリ分け

//	public List<ItemDetailDTO> getItemDetailListByCategoryId(int categoryId, int ItemId, int limitOffset,
//			int limitRowCount) {
//		DBConnector dbConnector = new DBConnector();
//		Connection connection = dbConnector.getConnection();
//		List<ItemDetailDTO> ItemDetailDtoList = new ArrayList<ItemDetailDTO>();
//		String sql = "select * from item_info_transaction where category_id=? and Item_id not in(?) order by rand() limit ?,?";
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			preparedStatement.setInt(1, categoryId);
//			preparedStatement.setInt(2, ItemId);
//			preparedStatement.setInt(3, limitOffset);
//			preparedStatement.setInt(4, limitRowCount);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				ItemDetailDTO ItemDetailDTO = new ItemDetailDTO();
//				ItemDetailDTO.setId(resultSet.getInt("id"));
//				ItemDetailDTO.setItemId(resultSet.getInt("Item_id"));
//				ItemDetailDTO.setItemName(resultSet.getString("Item_name"));
//				ItemDetailDTO.setItemPrice(resultSet.getString("item_price"));
////				ItemDetailDTO.setCategoryId(resultSet.getInt("category_id"));
//				ItemDetailDtoList.add(ItemDetailDTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ItemDetailDtoList;
//	}
//}


//	public List<ItemDetailDTO> getItemDetailListAll(String[] keywordsList) {
//		DBConnector dbConnector = new DBConnector();
//		Connection connection = dbConnector.getConnection();
//		List<ItemDetailDTO> ItemDetailDtoList = new ArrayList<ItemDetailDTO>();
//		String sql = "select * from item_info_transction";
//		boolean initializeFlag = true;
//		for (String keyword : keywordsList) {
//			if (initializeFlag) {
//				sql += " (Item_name like '%" + keyword + "%' or Item_name_kana like '%" + keyword + "%')";
//				initializeFlag = false;
//			} else {
//				sql += " and (Item_name like '%" + keyword + "%' or Item_name_kana like '%" + keyword + "%')";
//			}
//		}
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				ItemDetailDTO ItemDetailDTO = new ItemDetailDTO();
//				ItemDetailDTO.setId(resultSet.getInt("id"));
//				ItemDetailDTO.setItemId(resultSet.getInt("Item_id"));
//				ItemDetailDTO.setItemName(resultSet.getString("Item_name"));
////				ItemDetailDTO.setCategoryId(resultSet.getInt("category_id"));
//				ItemDetailDtoList.add(ItemDetailDTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ItemDetailDtoList;
//	}

//
//	public List<ItemDetailDTO> getItemDetailListByKeywords(String[] keywordsList, String categoryId) {
//		DBConnector dbConnector = new DBConnector();
//		Connection connection = dbConnector.getConnection();
//		List<ItemDetailDTO> ItemDetailDtoList = new ArrayList<ItemDetailDTO>();
//		String sql = "select * from item_info_transaction where";
//		boolean initializeFlag = true;
//		for (String keyword : keywordsList) {
//			if (initializeFlag) {
//				sql += " category_id=" + categoryId + " and (Item_name like '%" + keyword + "%' or Item_name_kana like '%" + keyword + "%')";
//				initializeFlag = false;
//			} else {
//				sql += " and (Item_name like '%" + keyword + "%' or Item_name_kana like '%" + keyword + "%')";
//			}
//		}
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(sql);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				ItemDetailDTO ItemDetailDTO = new ItemDetailDTO();
//				ItemDetailDTO.setId(resultSet.getInt("id"));
//				ItemDetailDTO.setItemId(resultSet.getInt("Item_id"));
//				ItemDetailDTO.setItemName(resultSet.getString("Item_name"));
//				ItemDetailDTO.setItemPrice(resultSet.getString("Item_price"));
//				ItemDetailDTO.setCategoryId(resultSet.getInt("category_id"));
//				ItemDetailDtoList.add(ItemDetailDTO);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		try {
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return ItemDetailDtoList;
//	}
//}
