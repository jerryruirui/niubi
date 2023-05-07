package com.wfuhui.modules.scenic.service;

import com.wfuhui.modules.scenic.entity.ScenicSpecEntity;

import java.util.List;
import java.util.Map;

/**
 * 景区规格
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public interface ScenicSpecService {
	
	ScenicSpecEntity queryObject(Integer id);
	
	List<ScenicSpecEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ScenicSpecEntity scenicSpec);
	
	void update(ScenicSpecEntity scenicSpec);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
