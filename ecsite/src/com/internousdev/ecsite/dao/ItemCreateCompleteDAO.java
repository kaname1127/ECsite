package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private DateUtil dateutil = new DateUtil();
	private String sql = "INSERT INTO item_info_transaction (item_name, item_price, item_stock, insert_date) VALUES(?, ? ,?, ?)";

	public void cerateItem(String ItemName, String ItemPrice, String ItemStock) throws SQLException {

		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, ItemName);
			preparedStatement.setString(2, ItemPrice);
			preparedStatement.setString(3, ItemStock);
			preparedStatement.setString(4, dateutil.getDate());
			preparedStatement.execute();
		}
		catch(Exception e) {
			e.printStackTrace();
		} finally {
		connection.close();
		}
	}
}
