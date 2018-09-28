package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemUpdateCompleteDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateUtil = new DateUtil();

	//ここからupdate文
	public int itemDetailUpdate(String id, String itemPrice, String itemStock) throws SQLException{
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "UPDATE item_info_transaction SET item_price =?, item_stock=?, update_date=? WHERE id=?";
		int result =0;
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, itemPrice);
			preparedStatement.setString(2, itemStock);
			preparedStatement.setString(3, dateUtil.getDate());
			preparedStatement.setString(4, id);
			result = preparedStatement.executeUpdate();
		}catch  (SQLException e){
				e.printStackTrace();
		} finally {
			connection.close();
		}
			return result;
		}

}
