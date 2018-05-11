package com.prography.appdev1.vo;

import java.util.ArrayList;

public class setDramaVo {
	
	public boolean success;
	public ArrayList<setDramaDataVo> setDramaList;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<setDramaDataVo> getSetDramaList() {
		return setDramaList;
	}
	public void setSetDramaList(ArrayList<setDramaDataVo> setDramaList) {
		this.setDramaList = setDramaList;
	}

}
