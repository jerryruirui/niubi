package com.wfuhui.modules.cms.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wfuhui.modules.cms.entity.ArticleEntity;
import com.wfuhui.modules.cms.service.ArticleService;
import com.wfuhui.modules.cms.service.ColumnService;
import com.wfuhui.modules.cms.service.CommentService;
import com.wfuhui.modules.cms.service.LikedService;
import com.wfuhui.common.annotation.AuthIgnore;
import com.wfuhui.common.utils.Query;
import com.wfuhui.common.utils.R;

/**
 * 景区
 * @author wfuhui
 *
 */
@RestController
@RequestMapping("/api/article")
public class ApiArticleController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LikedService likedService;

	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@AuthIgnore
	@RequestMapping("/list")
	public R list(@RequestParam Map<String, Object> params) {
		Query query = new Query(params);
		List<ArticleEntity> articleList = articleService.queryList(query);
		Integer total = articleService.queryTotal(params);
		return R.ok().put("articleList", articleList).put("total", total);
	}
	
	@RequestMapping("/isLike")
	public R isLike(Integer id, @RequestAttribute Long userId) {
		Boolean b = likedService.queryLiked(userId, id);
		return R.ok().put("isLike", b);
	}
	
	@AuthIgnore
	@RequestMapping("/detail")
	public R detail(Integer id, String token){
		ArticleEntity article = articleService.queryObject(id);
		return R.ok().put("article", article);
	}
	
	@RequestMapping("/getOneByColumnId")
	public R getOneByColumnId(Integer columnId) {
		ArticleEntity article = articleService.queryOneByColumnId(columnId);
		return R.ok().put("article", article);
	}
	
	@RequestMapping("/getOnByColumnCode")
	public R getOnByColumnCode(String columnCode, Long storeId) {
		ArticleEntity article = articleService.queryOneByColumnCode(columnCode, storeId);
		return R.ok().put("article", article);
	}
	
	@RequestMapping("/liked")
	public R liked(Integer articleId, @RequestAttribute Long userId) {
		articleService.liked(articleId, userId);
		return R.ok();
	}
	
	@RequestMapping("/unliked")
	public R unliked(Integer articleId, @RequestAttribute Long userId) {
		articleService.unliked(articleId, userId);
		return R.ok();
	}
		
}
