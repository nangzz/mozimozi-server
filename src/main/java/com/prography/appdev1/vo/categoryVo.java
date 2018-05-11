package com.prography.appdev1.vo;

import java.util.ArrayList;

public class categoryVo {
	
	public boolean success;
	public ArrayList<categoryDataVo> categoryList;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<categoryDataVo> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(ArrayList<categoryDataVo> categoryList) {
		this.categoryList = categoryList;
	}

}
