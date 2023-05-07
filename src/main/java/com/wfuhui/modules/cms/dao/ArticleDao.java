package com.wfuhui.modules.cms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wfuhui.modules.cms.entity.ArticleEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 
 * @author lizhengle
 * @email 123456789@qq.com
 */
@Mapper
public interface ArticleDao extends BaseDao<ArticleEntity> {

	ArticleEntity queryOneByColumnId(Integer columnId);

	ArticleEntity queryOneByColumnCode(@Param("columnCode")String columnCode, @Param("storeId")Long storeId);
	
}
