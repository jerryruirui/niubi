package com.wfuhui.modules.scenic.entity;

import java.io.Serializable;

/**
 * 景区图片
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
public class ScenicPicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 景区ID
	private Integer scenicId;
	// 图片
	private String picUrl;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：景区ID
	 */
	public void setscenicId(Integer scenicId) {
		this.scenicId = scenicId;
	}

	/**
	 * 获取：景区ID
	 */
	public Integer getscenicId() {
		return scenicId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
}
