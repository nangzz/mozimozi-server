package com.prography.appdev1.vo;

public class productDataVo {
	
	String p_url = "";
	String p_name = "";
	String p_img = "";
	String p_cat = "";
	int p_id = 0;
	int d_id = 0;
	int p_price = 0; 
	
	
	
	public void setP_url(String string) {
		p_url = string;
	}
	
	
	public String getP_url() {
		return p_url;
	}
	
	public void setP_id(int id) {
		p_id = id;
	}
	
	
	public int getP_id() {
		return p_id;
	}
	
	public void setD_id(int id) {
		d_id = id;
	}
	
	public int getD_id() {
		return d_id;
	}
	
	
	public int getP_pr() {
		return p_price;
	}
	
	public void setP_pr(int id) {
		p_price = id;
	}
	
	
	
	public void setP_name(String string) {
		p_name = string;
	}
	
	
	public String getP_name() {
		return p_name;
	}
	
	public void setP_img(String string) {
		p_img = string;
	}
	
	
	public String getP_img() {
		return p_img;
	}
	
	public void setP_cat(String string) {
		p_cat = string;
	}
	
	
	public String getP_cat() {
		return p_cat;
	}
	
	

}
