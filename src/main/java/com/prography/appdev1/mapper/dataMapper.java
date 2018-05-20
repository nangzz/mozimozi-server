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
import com.prography.appdev1.vo.SignUpDataVo;
import com.prography.appdev1.vo.UserMypageDataVo;


public interface dataMapper {
	
	
  public ArrayList<ChannelDramaDataVo> dramaChannelCheck(@Param("channelname") String channelname);
 
  public ArrayList<DramaCategoryDataVo> categoryDramaCheck();
  
  public ArrayList<CategoryProductDataVo> dramaProductCheck(@Param("dramaid") int dramaid, @Param("categoryname") String category);
  
  public ArrayList<UserMypageDataVo> userProductCheck(@Param("userid") String userid);
  
  public void SignUpCheck(@Param("userid") String userid, @Param("password") String password,
		  @Param("username") String username,@Param("usermail") String usermail);
  
  public ArrayList<UserMypageDataVo> mypageCheck(@Param("userid") String userid);
  
  public ArrayList<IdCheckDataVo> IdCheck(@Param("userid") String userid);
  
  public ArrayList<LoginDataVo> UserCheck(@Param("userid") String userid, @Param("password") String password);
  
  
}





