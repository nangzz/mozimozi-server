package com.prography.appdev1.vo;

import java.util.ArrayList;

public class productVo {
	
	public boolean success;
	
	public ArrayList<productDataVo> productlist;
	
	public boolean isSuccess(){
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public ArrayList<productDataVo> getProductlist(){
		return productlist;
	}
	
	public void setProductList (ArrayList<productDataVo> productlist) {
		this.productlist = productlist;
	}
	
	
	
	

}
