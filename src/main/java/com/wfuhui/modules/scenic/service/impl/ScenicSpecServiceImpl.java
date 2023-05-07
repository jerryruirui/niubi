package com.wfuhui.modules.scenic.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.wfuhui.modules.scenic.dao.ScenicSpecDao;
import com.wfuhui.modules.scenic.entity.ScenicSpecEntity;
import com.wfuhui.modules.scenic.service.ScenicSpecService;



@Service("scenicSpecService")
public class ScenicSpecServiceImpl implements ScenicSpecService {
	@Autowired
	private ScenicSpecDao scenicSpecDao;
	
	@Override
	public ScenicSpecEntity queryObject(Integer id){
		return scenicSpecDao.queryObject(id);
	}
	
	@Override
	public List<ScenicSpecEntity> queryList(Map<String, Object> map){
		return scenicSpecDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return scenicSpecDao.queryTotal(map);
	}
	
	@Override
	public void save(ScenicSpecEntity scenicSpec){
		scenicSpecDao.save(scenicSpec);
	}
	
	@Override
	public void update(ScenicSpecEntity scenicSpec){
		scenicSpecDao.update(scenicSpec);
	}
	
	@Override
	public void delete(Integer id){
		scenicSpecDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		scenicSpecDao.deleteBatch(ids);
	}
	
}
