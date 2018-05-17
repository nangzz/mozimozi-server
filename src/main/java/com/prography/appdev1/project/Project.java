package com.prography.appdev1.project;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prography.appdev1.mapper.dataMapper;
import com.prography.appdev1.vo.CategoryProductDataVo;
import com.prography.appdev1.vo.CategoryProductVo;
import com.prography.appdev1.vo.ChannelDramaDataVo;
import com.prography.appdev1.vo.ChannelDramaVo;
import com.prography.appdev1.vo.DramaCategoryDataVo;
import com.prography.appdev1.vo.DramaCateogoryVo;



@RestController //�� ���̸� ����ؼ� rest api�� ����� ���� �並 ������ �� �� �ƴ϶� ������ ó���� ���� ��Ʈ�ѷ��� ���� �� ����
public class Project {
	
	@RequestMapping("/sk") //��û�� url ������ �����ؼ� ����
	public String main() {
		return "sunkyung";
	}
	
	//���� �䱸���װ� ��Ī�Ǵ� ���ø����̼� ���ؽ�Ʈ�󿡼� �ٸ� ���� ã�� �� ���� �������� �ڵ����� ������Ű���� �ϴ� ����
	@Autowired //bean �̶� ����� �� �̰Ÿ� �����ϸ� getter setter�� �ڵ����� �����
	private dataMapper dm;
	

	@RequestMapping(value = "/channel", method = RequestMethod.POST)
	public @ResponseBody ChannelDramaVo dramaChannelCheck (HttpServletRequest request){
	//responseBody�� ���� http ��û ��ü�� �ڹ� ��ü�� ��ȯ�ϰ� �ڹ� ��ü�� http ���� ��ü�� ��ȯ�ϴµ� ���
		String channelname = ((String) request.getParameter("channelname"));
		
		ChannelDramaVo channelDrama = new ChannelDramaVo();
		
		ArrayList<ChannelDramaDataVo> channelDramaList = new ArrayList<ChannelDramaDataVo>(); 
		
		try {
			channelDramaList  = dm.dramaChannelCheck(channelname);
			
			if(channelDramaList.size() > 0) {
				channelDrama.setSuccess(true);
				channelDrama.setDramaList(channelDramaList);
			}
			else {
				channelDrama.setSuccess(false);
			}
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return channelDrama;
	}
	
	@RequestMapping(value = "/dramaCategory", method = RequestMethod.POST)
	public @ResponseBody DramaCateogoryVo categoryDramaCheck (HttpServletRequest request) {
		int dramaid = (Integer.parseInt(request.getParameter("dramaid")));
		
		DramaCateogoryVo category = new DramaCateogoryVo(); 
		
		ArrayList<DramaCategoryDataVo> categoryList = new ArrayList<DramaCategoryDataVo>();
		
		try {
			
			categoryList = dm.categoryDramaCheck(dramaid); 
			
			if(categoryList.size()>0) {
				category.setSuccess(true);;
				category.setDramacategoryList(categoryList);
			}
			else {
				category.setSuccess(false);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return category; 
	}
	
	@RequestMapping(value = "/DramaProduct", method = RequestMethod.POST)
	public @ResponseBody CategoryProductVo dramaProductCheck (HttpServletRequest request) {
		int dramaid = (Integer.parseInt(request.getParameter("dramaid")));
		String categoryname = ((String)request.getParameter("categoryname"));
		
		CategoryProductVo CategoryProduct = new CategoryProductVo();
		
		ArrayList<CategoryProductDataVo> categoryProductList = new ArrayList<CategoryProductDataVo>();
		
		try {
			categoryProductList = dm.dramaProductCheck(dramaid, categoryname);
			
			if(categoryProductList.size()>0) {
				CategoryProduct.setSuccess(true);
				CategoryProduct.setCategoryProductList(categoryProductList);
			}
			else {
				CategoryProduct.setSuccess(false);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return CategoryProduct;
	}
	
	
	

}
