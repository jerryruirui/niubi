package com.wfuhui.modules.scenic.service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.scenic.entity.ScenicEntity;

/**
 * 景区
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
public interface ScenicService {
	
	ScenicEntity queryObject(Integer id);
	
	List<ScenicEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ScenicEntity scenic);
	
	void update(ScenicEntity scenic);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	void updateStatus(Integer status, Integer[] ids);

	List<ScenicEntity> getLike(Long userId);
}
