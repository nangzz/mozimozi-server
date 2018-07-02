package com.prography.appdev1.vo;

import java.util.ArrayList;

public class PwSearchVo {
	
	public boolean success = false;
	public ArrayList<PwSearchDataVo> idpwList = new ArrayList<PwSearchDataVo>();

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<PwSearchDataVo> getIdpwList() {
		return idpwList;
	}
	public void setIdpwList(ArrayList<PwSearchDataVo> idpwList) {
		this.idpwList = idpwList;
	}
	
}
