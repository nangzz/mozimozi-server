package com.prography.appdev1.project;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@RestController // �� ���̸� ����ؼ� rest api�� ����� ���� �並 ������ �� �� �ƴ϶� ������ ó���� ���� ��Ʈ�ѷ��� ���� �� ����
public class Project {
	Logger log = Logger.getLogger(this.getClass());

	// ��ó: http://addio3305.tistory.com/43 [���� �������� ���� ��Ʈ]
	@RequestMapping("/sk") // ��û�� url ������ �����ؼ� ����
	public String main() {
		return "sunkyung";
	}

	// ���� �䱸���װ� ��Ī�Ǵ� ���ø����̼� ���ؽ�Ʈ�󿡼� �ٸ� ���� ã�� �� ���� �������� �ڵ����� ������Ű���� �ϴ� ����
	@Autowired // bean �̶� ����� �� �̰Ÿ� �����ϸ� getter setter�� �ڵ����� �����
	private dataMapper dm;

	//ä�κ� ��� �ѷ��ֱ�
	@CrossOrigin
	@RequestMapping(value = "/channel", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ChannelDramaVo dramaChannelCheck(@RequestBody Map<String, Object> json) {
		// responseBody�� ���� http ��û ��ü�� �ڹ� ��ü�� ��ȯ�ϰ� �ڹ� ��ü�� http ���� ��ü�� ��ȯ�ϴµ� ���

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

	
	//��� ���̵� �޾Ƽ� ��� ���� �ѷ��ֱ�
	@CrossOrigin
	@RequestMapping(value = "/dramaInfo", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody ChannelDramaVo dramaCheck(@RequestBody Map<String, Object> json) {
		// responseBody�� ���� http ��û ��ü�� �ڹ� ��ü�� ��ȯ�ϰ� �ڹ� ��ü�� http ���� ��ü�� ��ȯ�ϴµ� ���

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

	
	//�������� ��� �ѷ��ֱ�
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

	
	//ī�װ� �ѷ��ֱ�
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
	

	//top 10 ��ǰ �ѷ��ֱ�
	@CrossOrigin
	@RequestMapping(value = "/topProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo topProduct(@RequestBody Map<String, Object> json) {

		int clicknum = (int) json.get("clicknum");
		

		CategoryProductVo Product = new CategoryProductVo();
		ArrayList<CategoryProductDataVo> productList = new ArrayList<CategoryProductDataVo>();

		try {
			productList = dm.topProduct(clicknum);

			if (productList.size() > 0) {
				Product.setSuccess(true);
				Product.setCategoryProductList(productList);
			} else {
				Product.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Product;

	}


	
	//��� & �ι��� ���� ��ǰ
	@CrossOrigin
	@RequestMapping(value = "/ActorProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo actorProduct(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");
		String actorname = (String) json.get("actorname");

		CategoryProductVo actorProduct = new CategoryProductVo();
		ArrayList<CategoryProductDataVo> productList = new ArrayList<CategoryProductDataVo>();

		try {
			productList = dm.actorDramaCheck(dramaid, actorname);

			if (productList.size() > 0) {
				actorProduct.setSuccess(true);
				actorProduct.setCategoryProductList(productList);
			} else {
				actorProduct.setSuccess(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return actorProduct;

	}

	
	//��� & ī�װ��� ���� ��ǰ
	@CrossOrigin
	@RequestMapping(value = "/dramaProduct", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody CategoryProductVo dramaCategoryProductCheck(@RequestBody Map<String, Object> json) {

		int dramaid = (int) json.get("dramaid");
		String categoryname = (String) json.get("categoryname");

		CategoryProductVo CategoryProduct = new CategoryProductVo();

		ArrayList<CategoryProductDataVo> categoryProductList = new ArrayList<CategoryProductDataVo>();

		try {
			if (categoryname != null) {

				categoryProductList = dm.dramaCategoryProductCheck(dramaid, categoryname);
				if (categoryProductList.size() > 0) {

					CategoryProduct.setSuccess(true);
					CategoryProduct.setCategoryProductList(categoryProductList);
				}

				else {
					CategoryProduct.setSuccess(false);
				}
			} else {
				categoryProductList = dm.dramaProductCheck(dramaid);
				if (categoryProductList.size() > 0) {

					CategoryProduct.setSuccess(true);
					CategoryProduct.setCategoryProductList(categoryProductList);
				}

				else {
					CategoryProduct.setSuccess(false);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CategoryProduct;
	}

	
	//��󸶿� ���� ��ǰ��
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

	//�������� ��� ī�װ��� ���� ��ǰ
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

	
	//ȸ������
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
			signUp.setMessage("�Է��� ���̵�� �̹� �ִ� ���̵��Դϴ�. �ٸ� ���̵�� �������ּ���");
			e.printStackTrace();
		}
		return signUp;

	}

	//���������� ���ƿ�
	@CrossOrigin
	@RequestMapping(value = "/HeartCheck", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody HeartCheckVo HeartCheck(@RequestBody Map<String, Object> json) {

		String userid = (String) json.get("userid");
		int productid = (int) json.get("productid");

		HeartCheckVo heart = new HeartCheckVo();

		try {
			dm.HeartCheck(userid, productid);

			heart.setSuccess(true);
			
	        if(heart.isSuccess()) {
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
	
	//���������� �Ⱦ��
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

	//���������� 
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

	
	//���̵� �ߺ� Ȯ��
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
				id.setMessage("�Է��Ͻ� ���̵�� �̹� �ִ� ���̵� �Դϴ�. �ٸ� ���̵� �Է����ּ���");
			} else {
				id.setSuccess(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;

	}

		//���̵� ã��
		@CrossOrigin
		@RequestMapping(value = "/idSearch", method = RequestMethod.POST, consumes = "application/json")
		public @ResponseBody IdCheckVo IdSearch(@RequestBody Map<String, Object> json) {

			String username = (String) json.get("username");
			String useremail = (String)json.get("useremail");

			IdCheckVo id = new IdCheckVo();

			ArrayList<IdCheckDataVo> idCheck = new ArrayList<IdCheckDataVo>();

			try {
				idCheck = dm.idSearch(username,useremail);

				if (idCheck.size() > 0) {
					id.setSuccess(true);
					id.setIdList(idCheck);
				} else {
					id.setSuccess(false);
					id.setMessage("�Է��Ͻ� ȸ�������� �����ϴ�.");
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			return id;

		}
		
		//��й�ȣ ã��
				@CrossOrigin
				@RequestMapping(value = "/pwSearch", method = RequestMethod.POST, consumes = "application/json")
				public @ResponseBody PwSearchVo pwSearch(@RequestBody Map<String, Object> json) {

					String username = (String) json.get("username");
					String useremail = (String)json.get("useremail");
					String userid = (String)json.get("userid");
					
					PwSearchVo pw = new PwSearchVo();

					ArrayList<PwSearchDataVo> pwCheck = new ArrayList<PwSearchDataVo>();

					try {
						pwCheck = dm.pwSearch(username,useremail,userid);

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
				product.setSuccess(false);
				
				try{
					productList = dm.searchPcat(searchname);
					
					if (productList.size() > 0) {
						product.setSuccess(true);
						product.setCategoryProductList(productList);
					} 
					
					else {
						product.setSuccess(false);
						}
					
				}
				catch(Exception e) {
		            e.printStackTrace();

				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return product;

	}
	
	//�α���
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
				login.setMessage(userid);
			} else {
				login.setSuccess(false);
				login.setMessage("���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return login;

	}

}
