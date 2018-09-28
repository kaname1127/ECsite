package com.internousdev.ecsite.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.ItemDTO;
import com.internousdev.ecsite.dto.ItemDetailDTO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String loginUserId;
	private String loginPassword;
	private boolean adminRole;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	private ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
	private ArrayList<ItemDetailDTO> itemDetailDTOList = new ArrayList<ItemDetailDTO>();

	public String execute() throws SQLException {
		String result = ERROR;
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		session.put("loginUser", loginDTO);

		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			// 管理者権限
			session.put("adminRole", loginDTO.getAdminRole());

			if (loginDTO.getAdminRole()) {
				result = "MASTER";
			} else {
				itemDTOList = loginDAO.getItemInfo();
			}
		}

		return result;
	}

	public ArrayList<ItemDTO> getItemInfo() throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<ItemDTO> itemDTOList = new ArrayList<ItemDTO>();
		String sql = "SELECT id, item_name, item_price, item_stock FROM item_info_transaction ORDER BY id ASC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setId(resultSet.getString("id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				itemDTOList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return itemDTOList;
	}

	public List<ItemDetailDTO> getItemDetailInfo() {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ItemDetailDTO> itemDetailDTOList = new ArrayList<ItemDetailDTO>();
		String sql = "SELECT * FROM item_info_transaction";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				ItemDetailDTO dto = new ItemDetailDTO();
				dto.setId(resultSet.getInt("id"));
				// dto.setItemId(resultSet.getInt("item_id"));
				dto.setItemName(resultSet.getString("item_name"));
				dto.setItemPrice(resultSet.getString("item_price"));
				dto.setItemStock(resultSet.getString("item_stock"));
				dto.setInsertDate(resultSet.getString("insert_date"));
				itemDetailDTOList.add(dto);
			}
		} catch (SQLException e) {
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemDetailDTOList;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public boolean isAdminRole() {
		return adminRole;
	}

	public void AdminRole(boolean adminRole) {
		this.adminRole = adminRole;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
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