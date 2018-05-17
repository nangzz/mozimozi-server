package com.prography.appdev1.vo;

import java.util.ArrayList;

public class DramaCateogoryVo {
	
	public boolean success;
	public ArrayList<DramaCategoryDataVo> dramacategoryList;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<DramaCategoryDataVo> getDramacategoryList() {
		return dramacategoryList;
	}
	public void setDramacategoryList(ArrayList<DramaCategoryDataVo> dramacategoryList) {
		this.dramacategoryList = dramacategoryList;
	}
	
	
}
