package com.prography.appdev1.project;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
import com.prography.appdev1.vo.IdCheckDataVo;
import com.prography.appdev1.vo.IdCheckVo;
import com.prography.appdev1.vo.LoginDataVo;
import com.prography.appdev1.vo.LoginVo;
import com.prography.appdev1.vo.SignUpDataVo;
import com.prography.appdev1.vo.SignUpVo;
import com.prography.appdev1.vo.UserMypageDataVo;
import com.prography.appdev1.vo.UserMypageVo;



@RestController //�� ���̸� ����ؼ� rest api�� ����� ���� �並 ������ �� �� �ƴ϶� ������ ó���� ���� ��Ʈ�ѷ��� ���� �� ����
public class Project {
	Logger log = Logger.getLogger(this.getClass());

	//��ó: http://addio3305.tistory.com/43 [���� �������� ���� ��Ʈ]
	@RequestMapping("/sk") //��û�� url ������ �����ؼ� ����
	public String main() {
		return "sunkyung";
	}
	
	//���� �䱸���װ� ��Ī�Ǵ� ���ø����̼� ���ؽ�Ʈ�󿡼� �ٸ� ���� ã�� �� ���� �������� �ڵ����� ������Ű���� �ϴ� ����
	@Autowired //bean �̶� ����� �� �̰Ÿ� �����ϸ� getter setter�� �ڵ����� �����
	private dataMapper dm;
	
	
	@RequestMapping(value = "/channel", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ChannelDramaVo dramaChannelCheck (@RequestBody Map<String, Object> json){
	//responseBody�� ���� http ��û ��ü�� �ڹ� ��ü�� ��ȯ�ϰ� �ڹ� ��ü�� http ���� ��ü�� ��ȯ�ϴµ� ���

		
		String channelname = (String) json.get("channelname");

		
		log.debug("channelname > " + channelname);
		
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
	
	@RequestMapping(value = "/dramaCategory", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody DramaCateogoryVo categoryDramaCheck (@RequestBody Map<String, Object> json) {
		
		
		
		DramaCateogoryVo category = new DramaCateogoryVo(); 
		
		ArrayList<DramaCategoryDataVo> categoryList = new ArrayList<DramaCategoryDataVo>();
		
		try {
			
			categoryList = dm.categoryDramaCheck(); 
			
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
	
	@RequestMapping(value = "/dramaProduct", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody CategoryProductVo dramaProductCheck (@RequestBody Map<String, Object> json) {
		
		int dramaid = (int)json.get("dramaid");
		String categoryname = (String)json.get("categoryname");
		
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
	

	
	@RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SignUpVo SignUpCheck(@RequestBody Map<String, Object> json) {
		
		String userid = (String)json.get("userid");
		String password = (String)json.get("password");
		String username = (String)json.get("username");
		String usermail = (String)json.get("usermail");
		
		SignUpVo signUp = new SignUpVo();
		
		try {
			
			dm.SignUpCheck(userid, password, username, usermail);
			signUp.setSuccess(true);
			signUp.setMessage(null);
			
			
		}
		catch(Exception e) {
			
			signUp.setSuccess(false);
			signUp.setMessage("�Է��� ���̵�� �̹� �ִ� ���̵��Դϴ�. �ٸ� ���̵�� �������ּ���");
			e.printStackTrace();
		}
		return signUp;
		
	}
	
	@RequestMapping(value = "/mypage", method =  RequestMethod.POST, consumes = "application/json")
	public @ResponseBody UserMypageVo mypageCheck(@RequestBody Map<String,Object> json) {
		
		String userid = (String)json.get("userid");
		
		UserMypageVo mypage = new UserMypageVo();
		ArrayList<UserMypageDataVo> mypageList = new ArrayList<UserMypageDataVo>();
		
		try {
			mypageList = dm.mypageCheck(userid);
			
			if(mypageList.size()>0) {
				
				mypage.setSuccess(true);
				mypage.setMypageProduct(mypageList);
				
			}
			else {
				mypage.setSuccess(false);
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		return mypage;	
	}
	
	
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody IdCheckVo IdCheck(@RequestBody Map<String,Object> json) {
		
		String userid = (String)json.get("userid");
		
		IdCheckVo id = new IdCheckVo();
		
		ArrayList<IdCheckDataVo> idCheck = new ArrayList<IdCheckDataVo>();
		
		try {
			idCheck = dm.IdCheck(userid);
			
			if(idCheck.size()>0) {
				id.setSuccess(false);
				id.setMessage("�Է��Ͻ� ���̵�� �̹� �ִ� ���̵� �Դϴ�. �ٸ� ���̵� �Է����ּ���");
			}
			else {
				id.setSuccess(true);
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST,consumes = "application/json")
	public @ResponseBody LoginVo UserCheck(@RequestBody Map<String, Object> json) {
		
		String userid = (String)json.get("userid");
		String password = (String)json.get("password");
		
		LoginVo login = new LoginVo();
		ArrayList<LoginDataVo> loginresult = new ArrayList<LoginDataVo>();
		
		try {
			loginresult = dm.UserCheck(userid, password);
			
			if(loginresult.size()>0) {
				login.setSuccess(true);
				login.setMessage(userid);
			}
			else {
				login.setSuccess(false);
				login.setMessage("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return login;
		
	}
	
	
	
	
	
	
	

}
