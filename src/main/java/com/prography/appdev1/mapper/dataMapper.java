package com.prography.appdev1.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.prography.appdev1.vo.CategoryProductDataVo;
import com.prography.appdev1.vo.CategoryProductVo;
import com.prography.appdev1.vo.ChannelDramaDataVo;
import com.prography.appdev1.vo.ChannelDramaVo;
import com.prography.appdev1.vo.DramaCategoryDataVo;
import com.prography.appdev1.vo.DramaCateogoryVo;


public interface dataMapper {
	
	
  public ArrayList<ChannelDramaDataVo> dramaChannelCheck(@Param("channelname") String channelname);
 
  public ArrayList<DramaCategoryDataVo> categoryDramaCheck(@Param("dramaid") int dramaid);
  
  public ArrayList<CategoryProductDataVo> dramaProductCheck(@Param("dramaid") int dramaid, @Param("categoryname") String category);
 
}





