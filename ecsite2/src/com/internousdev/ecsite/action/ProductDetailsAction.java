package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ProductInfoDAO;
import com.internousdev.ecsite.dto.MCategoryDTO;
import com.internousdev.ecsite.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	private int productId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	private String categoryId;
	private String message;
	private String deleteFlg;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		if (!session.containsKey("id")) {
			return ERROR;
		}

		String result = ERROR;

		if (deleteFlg == null) {
			ProductInfoDAO productInfoDAO = new ProductInfoDAO();
			ProductInfoDTO productInfoDTO = new ProductInfoDTO();
			// productIdで特定の商品を紐付ける
			productInfoDTO = productInfoDAO.getProductInfo(productId);
			session.put("id", productInfoDTO.getId());
			session.put("productId", productInfoDTO.getProductId());
			session.put("productName", productInfoDTO.getProductName());
			session.put("productNameKana", productInfoDTO.getProductNameKana());
			session.put("imageFilePath", productInfoDTO.getImageFilePath());
			session.put("imageFileName", productInfoDTO.getImageFileName());
			session.put("price", productInfoDTO.getPrice());

			session.put("releaseCompany", productInfoDTO.getReleaseCompany());
			session.put("releaseDate", productInfoDTO.getReleaseDate());
			session.put("productDescription", productInfoDTO.getProductDescription());

			List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
			session.put("productCountList", productCountList);

			productInfoDtoList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(),
					productInfoDTO.getProductId(), 0, 3);
			Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
			if (!(iterator.hasNext())) {
				productCountList = null;
			}
			if (!productInfoDtoList.isEmpty() || productCountList == null) {
				session.put("productInfoDtoList", productInfoDtoList);
				if (session.get("status") == "1") { // ここから3行管理者用詳細ページのために追加
					result = "MASTER";
				} else {
					result = SUCCESS;
				}

			} else if (deleteFlg.equals("1")) {
				delete();
			}
		}
		return result;
	}

	// ここから管理者用のdelete文
	public void delete() throws SQLException {
		String id = session.get("id").toString();
		int res = productInfoDAO.productDtailDelete(id);
		if (res > 0) {
			productInfoDtoList = null;
			setMessage("商品情報を正しく削除しました");
		} else if (res == 0) {
			setMessage("商品情報の削除に失敗しました");
		}
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
