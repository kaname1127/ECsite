package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemDetailDAO;
import com.internousdev.ecsite.dto.ItemDetailDTO;
import com.internousdev.ecsite.dto.LoginDTO;
//import com.internousdev.ecsite.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemDetailAction extends ActionSupport implements SessionAware {
	// private int itemId;
	private String id;
	private String message;
	private String deleteFlg;
	private String result;
	private List<ItemDetailDTO> itemDetailDTOList = new ArrayList<ItemDetailDTO>();
	private ItemDetailDAO itemDetailDAO = new ItemDetailDAO();
	private LoginDTO loginDTO = new LoginDTO();
	// private List<MCategoryDTO> mCategoryDTOList = new
	// ArrayList<MCategoryDTO>();
	// private String categoryId;
	public Map<String, Object> session;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		// String result = ERROR;
		if (deleteFlg == null) {
			ItemDetailDAO itemDetailDAO = new ItemDetailDAO();
			ItemDetailDTO itemDetailDTO = new ItemDetailDTO();
			itemDetailDTO = itemDetailDAO.getItemDetail(id);
			session.put("id", itemDetailDTO.getId());
			session.put("itemName", itemDetailDTO.getItemName());
			session.put("itemPrice", itemDetailDTO.getItemPrice());
			session.put("itemStock", itemDetailDTO.getItemStock());
			// session.put("itemId", itemDetailDTO.getItemId());

			// sessionからadminRoleを取り出す。sessionにはobject型で入っているため、Boolean型に変換要。Object型→String型→Boolean型
			if (Boolean.parseBoolean(session.get("adminRole").toString())) {
				result = "MASTER";
			} else {
				result = SUCCESS;
			}
			// parseBoolean(String str)

		} else if (deleteFlg.equals("1")) {
			delete();
		}

		// List<Integer> itemCountList = new
		// ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		// session.put("productCountList", itemCountList);

		// itemDetailDTOList =
		// itemDetailDAO.getItemDetailListByCategoryId(itemDetailDTO.getCategoryId(),
		// itemDetailDTO.getItemId(), 0, 3);
		// itemDetailDTOList =
		// itemDetailDAO.getItemDetailList(itemDetailDTO.itemDetailDTO.getItemId(),
		// 0, 3);
		// java.util.Iterator<ItemDetailDTO> iterator =
		// itemDetailDTOList.iterator();
		// if(!(iterator.hasNext())) {
		// itemCountList = null;
		// }
		// if(!itemDetailDTOList.isEmpty() || itemCountList==null) {
		// session.put("itemDetailDTOList", itemDetailDTOList);

		// }
		return result;
	}

	// ここからdelete文
	public void delete() throws SQLException {
		String id = session.get("id").toString();
		int res = itemDetailDAO.itemDtailDelete(id);
		if (res > 0) {
			itemDetailDTOList = null;
			setMessage("商品情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました");
		}
	}

	// public int getItemId() {
	// return itemId;
	// }
	// public void setItemId(int itemId) {
	// this.itemId = itemId;
	// }

	// public List<MCategoryDTO> getmCategoryDTOList() {
	// return mCategoryDTOList;
	// }
	// public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList) {
	// this.mCategoryDTOList = mCategoryDTOList;
	// }

	public List<ItemDetailDTO> getItemDetailDTOList() {
		return itemDetailDTOList;
	}

	public void setItemDetailDTOList(ArrayList<ItemDetailDTO> itemDetailDTOList) {
		this.itemDetailDTOList = itemDetailDTOList;
	}

	// public String getCategoryId() {
	// return categoryId;
	// }
	// public void setCategoryId(String categoryId) {
	// this.categoryId = Id;
	// }

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ItemDetailDTO> getIitemDetaiDTOlList() {
		return this.itemDetailDTOList;
	}

	public ItemDetailDAO getItemDetailDAO() {
		return itemDetailDAO;
	}

	public void setItemDetailDAO(ItemDetailDAO itemDetailDAO) {
		this.itemDetailDAO = itemDetailDAO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

}
