package com.wfuhui.modules.scenic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 景区
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
public class ScenicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 景区名称
	private String scenicName;
	// 分类ID
	private Integer categoryId;
	// 价格
	private BigDecimal price;

	private String picUrl;
	// 描述
	private String describe;
	// 创建时间
	private Date createTime;

	private String[] picUrls;
	
	//上下架
	private Integer status;
	
	private List<ScenicSpecEntity> scenicSpecList;
	
	private String address;
	
	private Double lng;
	
	private Double lat;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 分类
	 */
	private CategoryEntity category;
	
	/**
	 * 设置：景区名称
	 */
	public void setScenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	/**
	 * 获取：景区名称
	 */
	public String getScenicName() {
		return scenicName;
	}

	/**
	 * 设置：分类ID
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获取：分类ID
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置：描述
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

	/**
	 * 获取：描述
	 */
	public String getDescribe() {
		if(describe == null) {
			return "";
		}
		return describe;
	}

	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String[] getPicUrls() {
		return picUrls;
	}

	public void setPicUrls(String[] picUrls) {
		this.picUrls = picUrls;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public List<ScenicSpecEntity> getScenicSpecList() {
		return scenicSpecList;
	}

	public void setScenicSpecList(List<ScenicSpecEntity> scenicSpecList) {
		this.scenicSpecList = scenicSpecList;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	
}
