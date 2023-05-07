package com.wfuhui.modules.scenic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.wfuhui.modules.scenic.entity.ScenicEntity;
import com.wfuhui.modules.sys.dao.BaseDao;

/**
 * 景区
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
@Mapper
public interface ScenicDao extends BaseDao<ScenicEntity> {

	void updateStatus(@Param("status")Integer status, @Param("ids")Integer[] ids);

	List<ScenicEntity> queryByIds(Integer[] id);
}
