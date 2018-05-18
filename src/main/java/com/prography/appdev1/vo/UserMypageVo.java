package com.prography.appdev1.vo;

import java.util.ArrayList;

public class UserMypageVo {
	
	
	public boolean success;
	public ArrayList<UserMypageDataVo> mypageProduct;
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<UserMypageDataVo> getMypageProduct() {
		return mypageProduct;
	}
	public void setMypageProduct(ArrayList<UserMypageDataVo> mypageProduct) {
		this.mypageProduct = mypageProduct;
	}

}
