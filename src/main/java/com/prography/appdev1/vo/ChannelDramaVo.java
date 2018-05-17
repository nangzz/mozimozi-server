package com.prography.appdev1.vo;

import java.util.ArrayList;

public class ChannelDramaVo {
	
	public boolean success = false;
	public ArrayList<ChannelDramaDataVo> dramaList = new ArrayList<ChannelDramaDataVo>();
	
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ArrayList<ChannelDramaDataVo> getDramaList() {
		return dramaList;
	}
	public void setDramaList(ArrayList<ChannelDramaDataVo> dramaList) {
		this.dramaList = dramaList;
	}

}
