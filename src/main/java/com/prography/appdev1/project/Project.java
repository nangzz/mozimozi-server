package com.prography.appdev1.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.prography.appdev1.vo.HeartCheckDataVo;
import com.prography.appdev1.vo.HeartCheckVo;
import com.prography.appdev1.vo.IdCheckDataVo;
import com.prography.appdev1.vo.IdCheckVo;
import com.prography.appdev1.vo.LoginDataVo;
import com.prography.appdev1.vo.LoginVo;
import com.prography.appdev1.vo.PwSearchDataVo;
import com.prography.appdev1.vo.PwSearchVo;
import com.prography.appdev1.vo.RandomDramaDataVo;
import com.prography.appdev1.vo.RandomDramaVo;
import com.prography.appdev1.vo.SignUpDataVo;
import com.prography.appdev1.vo.SignUpVo;
import com.prography.appdev1.vo.UserMypageDataVo;
import com.prography.appdev1.vo.UserMypageVo;

@RestController
public class Project {
	Logger log = Logger.getLogger(this.getClass());

	public String main() {
		return "sunkyung";
	}

	@Autowired
	private dataMapper dm;

	@CrossOrigin
	@RequestMapping(value = "/channel", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ChannelDramaVo dramaChannelCheck(@RequestBody Map<String, Object> json) {

		String channelname = (String) json.get("channelname");

		log.debug("channelname > " + channelname);

		ChannelDramaVo channelDrama = new ChannelDramaVo();

		ArrayList<ChannelDramaDataVo> channelDramaList = new ArrayList<ChannelDramaDataVo>();

		try {
			channelDramaList = dm.dramaChannelCheck(channelname);

			if (channelDramaList.size() > 0) {
				channelDrama.setSuccess(true);
				channelDrama.setDramaList(channelDramaList);
			} else {
				channelDrama.setSuccess(false);
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return channelDrama;
	}

	@CrossOrigin
	@RequestMapping(value = "/dramaInfo", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ChannelDramaVo dramaCheck(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");

		log.debug("dramaid > " + dramaid);

		ChannelDramaVo channelDrama = new ChannelDramaVo();

		ArrayList<ChannelDramaDataVo> channelDramaList = new ArrayList<ChannelDramaDataVo>();

		try {
			channelDramaList = dm.dramaCheck(dramaid);

			if (channelDramaList.size() > 0) {
				channelDrama.setSuccess(true);
				channelDrama.setDramaList(channelDramaList);
			} else {
				channelDrama.setSuccess(false);
			}
		}

		catch (Exception e) {

			e.printStackTrace();
		}

		return channelDrama;
	}

	@RequestMapping(value = "/RandomDrama", method = RequestMethod.GET)
	public @ResponseBody RandomDramaVo dramaList() {

		RandomDramaVo randomDrama = new RandomDramaVo();

		ArrayList<RandomDramaDataVo> dramaList = new ArrayList<RandomDramaDataVo>();

		try {
			dramaList = dm.dramaList();

			if (dramaList.size() > 0) {

				randomDrama.setSuccess(true);
				randomDrama.setDramaList(dramaList);
			} else {
				randomDrama.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return randomDrama;

	}

	@CrossOrigin
	@RequestMapping(value = "/dramaCategory", method = RequestMethod.GET)
	public @ResponseBody DramaCateogoryVo categoryDramaCheck() {

		DramaCateogoryVo category = new DramaCateogoryVo();

		ArrayList<DramaCategoryDataVo> categoryList = new ArrayList<DramaCategoryDataVo>();

		try {

			categoryList = dm.categoryDramaCheck();

			if (categoryList.size() > 0) {
				category.setSuccess(true);
				;
				category.setDramacategoryList(categoryList);
			} else {
				category.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return category;
	}


	@CrossOrigin
	@RequestMapping(value = "/mainTopProduct", method = RequestMethod.GET)
	public @ResponseBody CategoryProductVo topProductList() {

		
		CategoryProductVo mainProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> mainProductList = new ArrayList<CategoryProductDataVo>();

		try {
			mainProductList = dm.mainTopList();
			if (mainProductList.size() > 0) {
				mainProduct.setSuccess(true);
				;
				mainProduct.setCategoryProductList(mainProductList);
			} else {
				mainProduct.setSuccess(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return mainProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/topProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo topList(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");

		CategoryProductVo topProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> topProductList = new ArrayList<CategoryProductDataVo>();

		try {

			topProductList = dm.topList(dramaid);

			if (topProductList.size() > 0) {
				topProduct.setSuccess(true);
				topProduct.setCategoryProductList(topProductList);
			} else {
				topProduct.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return topProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/ActorProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo actorProduct(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");
		String actorname = (String) json.get("actorname");

		CategoryProductVo actorProduct = new CategoryProductVo();
		ArrayList<CategoryProductDataVo> productList = new ArrayList<CategoryProductDataVo>();

		try {

			if (actorname.equals(" ") ) {

				productList = dm.dramaProductCheck(dramaid);
				if (productList.size() > 0) {

					actorProduct.setSuccess(true);
					actorProduct.setCategoryProductList(productList);
				}

				else {
					actorProduct.setSuccess(false);
				}
				
			}

			else {
				productList = dm.actorDramaCheck(dramaid,actorname);
				if(productList.size()>0) {
					actorProduct.setSuccess(true);
					actorProduct.setCategoryProductList(productList);}
				else {
					actorProduct.setSuccess(false);
					}
				}
			
			
		
	

	} catch (Exception e) {
		e.printStackTrace();
	}

		return actorProduct;

	}

	@CrossOrigin
	@RequestMapping(value = "/dramaProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo dramaCategoryProductCheck(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");
		String categoryname = (String) json.get("categoryname");

		CategoryProductVo CategoryProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> categoryProductList = new ArrayList<CategoryProductDataVo>();

		try {
				//categoryProductList = dm.dramaCategoryProductCheck(dramaid,categoryname);
				
				if (categoryname.equals(" ") ) {

					categoryProductList = dm.dramaProductCheck(dramaid);
					if (categoryProductList.size() > 0) {

						CategoryProduct.setSuccess(true);
						CategoryProduct.setCategoryProductList(categoryProductList);
					}

					else {
						CategoryProduct.setSuccess(false);
					}
					
				}

				else {
					categoryProductList = dm.dramaCategoryProductCheck(dramaid,categoryname);
					if(categoryProductList.size()>0) {
						CategoryProduct.setSuccess(true);
						CategoryProduct.setCategoryProductList(categoryProductList);}
					else {
						CategoryProduct.setSuccess(false);
						}
					}
				
				
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CategoryProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/Product", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo ProductCheck(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");

		CategoryProductVo CategoryProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> categoryProductList = new ArrayList<CategoryProductDataVo>();

		try {
			categoryProductList = dm.ProductCheck(dramaid);

			if (categoryProductList.size() > 0) {

				CategoryProduct.setSuccess(true);
				CategoryProduct.setCategoryProductList(categoryProductList);
			}

			else {
				CategoryProduct.setSuccess(false);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return CategoryProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/cProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo cProductCheck(@RequestBody Map<String, Object> json) {

		String categoryname = (String) json.get("categoryname");

		CategoryProductVo CategoryProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> categoryProductList = new ArrayList<CategoryProductDataVo>();

		try {
			categoryProductList = dm.cProductCheck(categoryname);

			if (categoryProductList.size() > 0) {

				CategoryProduct.setSuccess(true);
				CategoryProduct.setCategoryProductList(categoryProductList);
			}

			else {
				CategoryProduct.setSuccess(false);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return CategoryProduct;
	}

	@CrossOrigin
	@RequestMapping(value = "/signUp", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody SignUpVo SignUpCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");
		String password = (String) json.get("password");
		String username = (String) json.get("username");
		String usermail = (String) json.get("usermail");

		SignUpVo signUp = new SignUpVo();

		try {

			dm.SignUpCheck(userid, password, username, usermail);
			signUp.setSuccess(true);
			signUp.setMessage(null);

		} catch (Exception e) {

			signUp.setSuccess(false);
			signUp.setMessage("입력하신 아이디는 이미 있는 아이디입니다.");
			e.printStackTrace();
		}
		return signUp;

	}

	@CrossOrigin
	@RequestMapping(value = "/HeartCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HeartCheckVo HeartCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");
		int productid = (int) json.get("productid");

		HeartCheckVo heart = new HeartCheckVo();

		try {
			dm.HeartCheck(userid, productid);

			heart.setSuccess(true);

			if (heart.isSuccess()) {
				try {
					dm.increaseClickCount(productid);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		} catch (Exception e) {
			e.printStackTrace();

			heart.setSuccess(false);
		}
		return heart;

	}

	@CrossOrigin
	@RequestMapping(value = "/HeartRemove", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HeartCheckVo HeartRemove(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");
		int productid = (int) json.get("productid");

		HeartCheckVo heart = new HeartCheckVo();

		try {
			dm.HeartRemove(userid, productid);

			heart.setSuccess(true);

		} catch (Exception e) {
			e.printStackTrace();

			heart.setSuccess(false);
		}
		return heart;

	}

	// 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙
	@CrossOrigin
	@RequestMapping(value = "/mypage", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody UserMypageVo mypageCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");

		UserMypageVo mypage = new UserMypageVo();
		ArrayList<UserMypageDataVo> mypageList = new ArrayList<UserMypageDataVo>();

		try {
			mypageList = dm.mypageCheck(userid);

			if (mypageList.size() > 0) {

				mypage.setSuccess(true);
				mypage.setMypageProduct(mypageList);

			} else {
				mypage.setSuccess(false);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return mypage;
	}

	@CrossOrigin
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody IdCheckVo IdCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");

		IdCheckVo id = new IdCheckVo();

		ArrayList<IdCheckDataVo> idCheck = new ArrayList<IdCheckDataVo>();

		try {
			idCheck = dm.IdCheck(userid);

			if (idCheck.size() > 0) {
				id.setSuccess(false);
				id.setMessage("입력하신 아이디는 이미 있는 아이디입니다.");
			} else {
				id.setSuccess(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;

	}

	@CrossOrigin
	@RequestMapping(value = "/idSearch", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody IdCheckVo IdSearch(@RequestBody Map<String, Object> json) {

		String username = (String) json.get("username");
		String useremail = (String) json.get("useremail");

		IdCheckVo id = new IdCheckVo();

		ArrayList<IdCheckDataVo> idCheck = new ArrayList<IdCheckDataVo>();

		try {
			idCheck = dm.idSearch(username, useremail);

			if (idCheck.size() > 0) {
				id.setSuccess(true);
				id.setIdList(idCheck);
			} else {
				id.setSuccess(false);
				id.setMessage("입력하신 아이디는 존재하지 않습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;

	}

	// 占쏙옙橘占싫� 찾占쏙옙
	@CrossOrigin
	@RequestMapping(value = "/pwSearch", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody PwSearchVo pwSearch(@RequestBody Map<String, Object> json) {

		String username = (String) json.get("username");
		String useremail = (String) json.get("useremail");
		String userid = (String) json.get("userid");

		PwSearchVo pw = new PwSearchVo();

		ArrayList<PwSearchDataVo> pwCheck = new ArrayList<PwSearchDataVo>();

		try {
			pwCheck = dm.pwSearch(username, useremail, userid);

			if (pwCheck.size() > 0) {
				pw.setSuccess(true);
				pw.setIdpwList(pwCheck);
			} else {
				pw.setSuccess(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return pw;

	}

	@CrossOrigin
	@RequestMapping(value = "/itemSearch", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo searchCheck(@RequestBody Map<String, Object> json) {

		String searchname = (String) json.get("searchname");
		

		CategoryProductVo product = new CategoryProductVo();
		ArrayList<CategoryProductDataVo> productList = new ArrayList<CategoryProductDataVo>();

		try {
			
			productList = dm.searchPname(searchname);

			if (productList.size() > 0) {
				product.setSuccess(true);
				product.setCategoryProductList(productList);
			}

			else {

					productList = dm.searchPcat(searchname);

					if (productList.size() > 0) {
						product.setSuccess(true);
						product.setCategoryProductList(productList);
					}

					else {
						product.setSuccess(false);
					}


			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;

	}

	// 占싸깍옙占쏙옙
	@CrossOrigin
	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody LoginVo UserCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");
		String password = (String) json.get("password");

		LoginVo login = new LoginVo();
		ArrayList<LoginDataVo> loginresult = new ArrayList<LoginDataVo>();

		try {
			loginresult = dm.UserCheck(userid, password);

			if (loginresult.size() > 0) {
				login.setSuccess(true);
				login.setUserInfo(loginresult);
			} else {
				login.setSuccess(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;

	}

}
