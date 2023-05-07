package com.wfuhui.modules.scenic.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 景区规格
 * 
 * @author lizhengle
 * @email 2803180149@qq.com
 */
public class ScenicSpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//规格名称
	private String specName;
	//价格
	private BigDecimal price;
	//景区id
	private Integer scenicId;

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
	 * 设置：规格名称
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	/**
	 * 获取：规格名称
	 */
	public String getSpecName() {
		return specName;
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
	 * 设置：景区id
	 */
	public void setscenicId(Integer scenicId) {
		this.scenicId = scenicId;
	}
	/**
	 * 获取：景区id
	 */
	public Integer getscenicId() {
		return scenicId;
	}
}
