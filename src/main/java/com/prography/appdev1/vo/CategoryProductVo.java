package com.prography.appdev1.vo;

import java.util.ArrayList;

public class CategoryProductVo {
	
	public boolean success;
	public ArrayList<CategoryProductDataVo> categoryProductList;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<CategoryProductDataVo> getCategoryProductList() {
		return categoryProductList;
	}
	public void setCategoryProductList(ArrayList<CategoryProductDataVo> categoryProductList) {
		this.categoryProductList = categoryProductList;
	}

}
