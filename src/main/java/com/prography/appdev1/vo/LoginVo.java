package com.prography.appdev1.vo;

import java.util.ArrayList;

public class LoginVo {
	
	boolean success;
	ArrayList<LoginDataVo> UserInfo = new ArrayList<LoginDataVo>();
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<LoginDataVo> getUserInfo() {
		return UserInfo;
	}
	public void setUserInfo(ArrayList<LoginDataVo> userInfo) {
		UserInfo = userInfo;
	}

	
	
	

}
