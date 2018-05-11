package com.prography.appdev1.vo;

import java.util.ArrayList;

public class mypageVo {
	
	public boolean success;
	public ArrayList<mypageDataVo> mypageList;
	
	public void setSuccess(boolean suc) {
		success = suc;
	}
	
	public boolean getSuccess() {
		return success;
	}
	
	public void setMypageList(ArrayList<mypageDataVo> mypageList) {
		this.mypageList = mypageList;
	}
	
	public ArrayList<mypageDataVo> getMypageList(){
		return mypageList;
	}
	
	

}
