package com.wfuhui.modules.scenic.dao;

import org.apache.ibatis.annotations.Mapper;

import com.wfuhui.modules.scenic.entity.ScenicPicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 景区图片
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
@Mapper
public interface ScenicPicDao extends BaseDao<ScenicPicEntity> {

	String[] queryByScenicId(Integer scenicId);

	void deleteByScenicId(Integer scenicId);
	
}
