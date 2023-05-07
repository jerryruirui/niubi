package com.wfuhui.modules.scenic.dao;

import com.wfuhui.modules.scenic.entity.ScenicSpecEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * 景区规格
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
@Mapper
public interface ScenicSpecDao extends BaseDao<ScenicSpecEntity> {

	List<ScenicSpecEntity> queryByScenicId(Integer id);
	
}
