package com.wfuhui.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author lzl
 * @email 2803180149@qq.com
 */
public class OrderScenicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//
	private Integer id;
	// 订单ID
	private Integer orderId;
	// 景区ID
	private Integer scenicId;

	private Integer num;

	private String picUrl;

	private BigDecimal price;

	private String scenicName;
	
	private String specName;

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
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 设置：景区ID
	 */
	public void setScenicId(Integer scenicId) {
		this.scenicId = scenicId;
	}

	/**
	 * 获取：景区ID
	 */
	public Integer getScenicId() {
		return scenicId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getscenicName() {
		return scenicName;
	}

	public void setscenicName(String scenicName) {
		this.scenicName = scenicName;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

}
