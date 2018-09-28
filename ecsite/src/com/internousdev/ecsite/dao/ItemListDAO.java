package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	public ArrayList<ItemDTO> getItemInfo() throws SQLException {
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


			public int itemListHistoryDelete() throws SQLException{
//			(String item_transaction_id, String item_transaction_item_name, String item_transaction_item_price, String item_transaction_item_stock)
			String sql = "DELETE FROM item_info_transaction";
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