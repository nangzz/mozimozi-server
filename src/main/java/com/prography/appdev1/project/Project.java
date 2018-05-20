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



@RestController //이 아이를 사용해서 rest api를 만들수 있음 뷰를 만들어내는 것 뿐 아니라 데이터 처리를 위한 컨트롤러를 만들어낼 수 있음
public class Project {
	Logger log = Logger.getLogger(this.getClass());

	//출처: http://addio3305.tistory.com/43 [흔한 개발자의 개발 노트]
	@RequestMapping("/sk") //요청의 url 패턴을 지정해서 매핑
	public String main() {
		return "sunkyung";
	}
	
	//빈의 요구사항과 매칭되는 애플리케이션 컨텍스트상에서 다른 빈을 찾아 빈 간의 의존성을 자동으로 만족시키도록 하는 수단
	@Autowired //bean 이랑 비슷한 애 이거를 선언하면 getter setter를 자동으로 만들어
	private dataMapper dm;
	
	
	@RequestMapping(value = "/channel", method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ChannelDramaVo dramaChannelCheck (@RequestBody Map<String, Object> json){
	//responseBody는 각각 http 요청 몸체를 자바 객체로 변환하고 자바 객체를 http 응답 몸체로 변환하는데 사용

		
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
			signUp.setMessage("입력한 아이디는 이미 있는 아이디입니다. 다른 아이디로 가입해주세요");
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
				id.setMessage("입력하신 아이디는 이미 있는 아이디 입니다. 다른 아이디를 입력해주세요");
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
				login.setMessage("아이디 또는 비밀번호가 일치하지 않습니다.");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return login;
		
	}
	
	
	
	
	
	
	

}
