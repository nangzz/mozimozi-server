package com.prography.appdev1.vo;

import java.util.ArrayList;

public class RandomDramaVo {

	public boolean success = false;
	public ArrayList<RandomDramaDataVo> dramaList = new ArrayList<RandomDramaDataVo>();
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<RandomDramaDataVo> getDramaList() {
		return dramaList;
	}
	public void setDramaList(ArrayList<RandomDramaDataVo> dramaList) {
		this.dramaList = dramaList;
	}
	
	
}
