package com.prography.appdev1.vo;

import java.util.ArrayList;

public class IdCheckVo {
	
	boolean success;
	String message = "";
	ArrayList<IdCheckDataVo> idList = new ArrayList<IdCheckDataVo>();
	
	public boolean isSuccess() {
		return success;
	}
	
	public ArrayList<IdCheckDataVo> getIdList() {
		return idList;
	}

	public void setIdList(ArrayList<IdCheckDataVo> idList) {
		this.idList = idList;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
	

}
