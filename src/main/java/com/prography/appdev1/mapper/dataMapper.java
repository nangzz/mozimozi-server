package com.prography.appdev1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.prography.appdev1.vo.CategoryProductDataVo;
import com.prography.appdev1.vo.CategoryProductVo;
import com.prography.appdev1.vo.ChannelDramaDataVo;
import com.prography.appdev1.vo.ChannelDramaVo;
import com.prography.appdev1.vo.DramaCategoryDataVo;
import com.prography.appdev1.vo.DramaCateogoryVo;
import com.prography.appdev1.vo.IdCheckDataVo;
import com.prography.appdev1.vo.LoginDataVo;
import com.prography.appdev1.vo.PwSearchDataVo;
import com.prography.appdev1.vo.RandomDramaDataVo;
import com.prography.appdev1.vo.SignUpDataVo;
import com.prography.appdev1.vo.UserMypageDataVo;


public interface dataMapper {
	
	
  public ArrayList<ChannelDramaDataVo> dramaChannelCheck(@Param("channelname") String channelname);
  
  public ArrayList<ChannelDramaDataVo> dramaCheck(@Param("dramaid") int dramaid);
 
  public ArrayList<DramaCategoryDataVo> categoryDramaCheck();
  
  public ArrayList<CategoryProductDataVo> dramaCategoryProductCheck(@Param("dramaid") int dramaid, @Param("categoryname") String category);
  
  public ArrayList<CategoryProductDataVo> ProductCheck(@Param("dramaid") int dramaid);
  
  public ArrayList<CategoryProductDataVo> cProductCheck(@Param("categoryname") String categoryname);
  
  public ArrayList<CategoryProductDataVo> dramaProductCheck(@Param("dramaid") int dramaid);
  
  public ArrayList<CategoryProductDataVo> actorDramaCheck(@Param("dramaid") int dramaid, @Param("actorname") String actorname);
  
  
  public ArrayList<UserMypageDataVo> userProductCheck(@Param("userid") String userid);
  
  public void SignUpCheck(@Param("userid") String userid, @Param("password") String password,
		  @Param("username") String username,@Param("usermail") String usermail);
  
  public void HeartCheck(@Param("userid") String userid, @Param("productid") int productid);
  
  public void HeartRemove(@Param("userid") String userid, @Param("productid") int productid);
  
  public ArrayList<UserMypageDataVo> mypageCheck(@Param("userid") String userid);
  
  public ArrayList<IdCheckDataVo> IdCheck(@Param("userid") String userid);
  
  public ArrayList<LoginDataVo> UserCheck(@Param("userid") String userid, @Param("password") String password);
  
  public ArrayList<RandomDramaDataVo> dramaList();
  
  public ArrayList<CategoryProductDataVo> searchPname(@Param("searchname") String searchname);
  
  public ArrayList<CategoryProductDataVo> searchPcat(@Param("searchname") String searchname);
  
  public ArrayList<IdCheckDataVo> idSearch(@Param("username") String username, @Param("useremail") String useremail);
  
  public ArrayList<PwSearchDataVo> pwSearch(@Param("username") String username, @Param("useremail") String useremail,@Param("userid")String userid);
  
  public ArrayList<CategoryProductDataVo> topProduct(@Param("clicknum") int clicknum);
}





