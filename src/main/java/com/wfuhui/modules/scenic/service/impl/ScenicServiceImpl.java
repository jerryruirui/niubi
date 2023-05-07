package com.wfuhui.modules.scenic.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wfuhui.modules.scenic.dao.ScenicDao;
import com.wfuhui.modules.scenic.dao.ScenicPicDao;
import com.wfuhui.modules.scenic.dao.ScenicSpecDao;
import com.wfuhui.modules.scenic.dao.HistoryDao;
import com.wfuhui.modules.scenic.entity.ScenicEntity;
import com.wfuhui.modules.scenic.entity.ScenicPicEntity;
import com.wfuhui.modules.scenic.entity.ScenicSpecEntity;
import com.wfuhui.modules.scenic.entity.HistoryEntity;
import com.wfuhui.modules.scenic.service.ScenicService;
import com.wfuhui.modules.member.dao.MemberDao;
import com.wfuhui.modules.member.entity.MemberEntity;


@Service("scenicService")
public class ScenicServiceImpl implements ScenicService {
	@Autowired
	private ScenicDao scenicDao;
	@Autowired
	private ScenicPicDao scenicPicDao;
	@Autowired
	private HistoryDao historyDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ScenicSpecDao scenicSpecDao;
	
	@Override
	public ScenicEntity queryObject(Integer id){
		String[] picUrls = scenicPicDao.queryByScenicId(id);
		ScenicEntity scenic = scenicDao.queryObject(id);
		List<ScenicSpecEntity> scenicSpecList = scenicSpecDao.queryByScenicId(id);
		scenic.setScenicSpecList(scenicSpecList);
		scenic.setPicUrls(picUrls);
		return scenic;
	}
	
	@Override
	public List<ScenicEntity> queryList(Map<String, Object> map){
		List<ScenicEntity> scenicList = scenicDao.queryList(map);
		return scenicList;
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return scenicDao.queryTotal(map);
	}
	
	@Override
	public void save(ScenicEntity scenic){
		scenicDao.save(scenic);
		if (scenic.getPicUrls() != null) {
			String[] picUrls = scenic.getPicUrls();
			for (String picUrl : picUrls) {
				ScenicPicEntity scenicPic = new ScenicPicEntity();
				scenicPic.setscenicId(scenic.getId());
				scenicPic.setPicUrl(picUrl);
				scenicPicDao.save(scenicPic);
			}
		}
		
		if(scenic.getScenicSpecList() != null) {
			for (ScenicSpecEntity scenicSpec : scenic.getScenicSpecList()) {
				scenicSpec.setscenicId(scenic.getId());
				scenicSpecDao.save(scenicSpec);
			}
		}
	}
	
	@Override
	public void update(ScenicEntity scenic){
		if (scenic.getPicUrls() != null) {
			String[] picUrls = scenicPicDao.queryByScenicId(scenic.getId());
			boolean e = isQualsPic(picUrls, scenic.getPicUrls());
			if (!e) {
				scenicPicDao.deleteByScenicId(scenic.getId());
				for (String picUrl : scenic.getPicUrls()) {
					ScenicPicEntity scenicPic = new ScenicPicEntity();
					scenicPic.setscenicId(scenic.getId());
					scenicPic.setPicUrl(picUrl);
					scenicPicDao.save(scenicPic);
				}
			}
		}
		scenicDao.update(scenic);
		
		if(scenic.getScenicSpecList() != null) {
			for (ScenicSpecEntity scenicSpec : scenic.getScenicSpecList()) {
				scenicSpecDao.update(scenicSpec);
			}
		}
	}
	
	private boolean isQualsPic(String[] picUrls, String[] picUrls2) {
		if (picUrls.length == picUrls2.length) {
			for (int i = 0; i < picUrls.length; i++) {
				if (!picUrls[i].equals(picUrls2[i])) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	public void delete(Integer id){
		scenicDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		scenicDao.deleteBatch(ids);
	}
	
	@Override
	public void updateStatus(Integer status, Integer[] ids) {
		scenicDao.updateStatus(status, ids);
	}
	
	
	/**
	 * 可能喜欢
	 * */
	@Override
    public List<ScenicEntity> getLike(Long userId) {
		
        return new ArrayList<ScenicEntity>();
    }
}
