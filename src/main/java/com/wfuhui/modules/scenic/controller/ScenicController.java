package com.wfuhui.modules.scenic.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.scenic.entity.ScenicEntity;
import com.wfuhui.modules.scenic.service.ScenicService;


/**
 * 景区
 * 
 * @author lzl
 * @email 2803180149@qq.com
 * @date 2017-07-14 13:43:12
 */
@RestController
@RequestMapping("/scenic")
public class ScenicController {
	@Autowired
	private ScenicService scenicService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<ScenicEntity> scenicList = scenicService.queryList(query);
		int total = scenicService.queryTotal(query);
		
		return R.ok().put("rows", scenicList).put("total", total);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ScenicEntity scenic = scenicService.queryObject(id);
		
		return R.ok().put("scenic", scenic);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	public R save(@RequestBody ScenicEntity scenic){
		scenic.setCreateTime(new Date());
		scenicService.save(scenic);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public R update(@RequestBody ScenicEntity scenic){
		scenicService.update(scenic);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		scenicService.deleteBatch(ids);
		
		return R.ok();
	}
	
    @RequestMapping("/lower")
    public R lower(@RequestBody Integer[] ids) {
    	scenicService.updateStatus(0, ids);
    	return R.ok();
    }
    
    @RequestMapping("/upper")
    public R upper(@RequestBody Integer[] ids) {
    	scenicService.updateStatus(1, ids);
    	return R.ok();
    }
	
	@RequestMapping("/getAll")
	public R getAll() {
		List<ScenicEntity> scenicList = scenicService.queryList(null);
		return R.ok().put("scenicList", scenicList);
	}
	
}
