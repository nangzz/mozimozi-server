package com.prography.appdev1.project;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prography.appdev1.mapper.dataMapper;
import com.prography.appdev1.vo.userinfoDataVo;
import com.prography.appdev1.vo.userinfoVo;
import com.prography.appdev1.vo.categoryDataVo;
import com.prography.appdev1.vo.categoryVo;
import com.prography.appdev1.vo.mypageDataVo;
import com.prography.appdev1.vo.mypageVo;
import com.prography.appdev1.vo.productDataVo;
import com.prography.appdev1.vo.productVo;
import com.prography.appdev1.vo.relativeDataVo;
import com.prography.appdev1.vo.relativeVo;
import com.prography.appdev1.vo.setDramaDataVo;
import com.prography.appdev1.vo.setDramaVo;


@RestController
public class project {
	
	@RequestMapping("/sk")
	public String main() {
		return "sunkyung";
	}
	
	
	
	@Autowired //bean 이랑 비슷한 애 이거를 선언하면 getter setter를 자동으로 만들어
	private dataMapper dm;
	

	
	@RequestMapping("/userinfoVo")
	public @ResponseBody userinfoVo userinfoByVo() throws Exception{
		
		userinfoVo objectVo = new userinfoVo();
		
		try {
			ArrayList<userinfoDataVo> data = dm.userinfoList();
			
			if(data.size()>0) {
				
				objectVo.setUserinfoList(data);
			}
			
			else { 
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objectVo;
		
	}
	
	
	@RequestMapping("/productVo")
	public @ResponseBody productVo productByVo() throws Exception{
		
		productVo objectVo = new productVo();
		
		try {
			ArrayList<productDataVo> data = dm.productList();
			
			if(data.size()>0) {
				objectVo.setSuccess(true);
				objectVo.setProductList(data);
			}
			else {
				objectVo.setSuccess(false);
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return objectVo;
	}
	
	@RequestMapping("/mypageVo")
	public @ResponseBody mypageVo mypageByVo() throws Exception{
		
		mypageVo objectVo = new mypageVo();
		
		try {
			ArrayList<mypageDataVo> data = dm.mypageList();
			
			if(data.size()>0) {
				objectVo.setSuccess(true);
				objectVo.setMypageList(data);
			}
			else {
				objectVo.setSuccess(false);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objectVo;
	}
	
	@RequestMapping("/relativeVo")
	public @ResponseBody relativeVo relativeByVo() throws Exception{
		
		relativeVo objectVo = new relativeVo();
		
		try {
			ArrayList<relativeDataVo> data = dm.relativeList();
			
			if(data.size()>0) {
				objectVo.setRelativeList(data);
			}
			else {
				return null;
			}
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		return objectVo;
		
	}
	
	
	@RequestMapping("/categoryVo")
	public @ResponseBody categoryVo categoryByVo() throws Exception{
		
		categoryVo objectVo = new categoryVo();
		
		try {
			ArrayList<categoryDataVo> data = dm.categoryList();
			
			if(data.size()>0) {
				objectVo.setSuccess(true);
				objectVo.setCategoryList(data);
			}
			else {
				objectVo.setSuccess(false);
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return objectVo;
	}
	
	@RequestMapping("/setDramaVo")
	public @ResponseBody setDramaVo setDramaByVo() throws Exception{
		
		setDramaVo objectVo = new setDramaVo();
		
		try {
			ArrayList<setDramaDataVo> data = dm.setDramaList();
			
			if(data.size()>0) {
				objectVo.setSuccess(true);
				objectVo.setSetDramaList(data);
			}
			else {
				objectVo.setSuccess(false);
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return objectVo;
	}
	

}
