package com.wfuhui.modules.scenic.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;
import com.wfuhui.modules.scenic.entity.ScenicEntity;
import com.wfuhui.modules.scenic.service.ScenicService;

/**
 * 景区接口
 * @author lzl
 *
 */
@RestController
@RequestMapping("/api/scenic")
public class ApiScenicController {
	
	@Autowired
	private ScenicService scenicService;
	
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	@AuthIgnore
	@GetMapping("list")
    public R list(@RequestParam Map<String, Object> map){
		Query query = new Query(map);
    	List<ScenicEntity> scenicList = scenicService.queryList(query);
    	Integer total = scenicService.queryTotal(map);
        return R.ok().put("scenicList", scenicList).put("total", total);
    }
    
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@AuthIgnore
    @GetMapping("detail")
    public R detail(int id){
    	ScenicEntity scenic = scenicService.queryObject(id);
    	return R.ok().put("scenic", scenic);
    }
	
	
	@GetMapping("recommend")
    public R recommend(@RequestAttribute("userId") Long userId){
    	List<ScenicEntity> scenicList = scenicService.getLike(userId);
        return R.ok().put("scenicList", scenicList);
    }
    
}
