package com.accountmanage.pojo.prod;

import java.util.Date;

public class CouponRuleInfo {

	private String couponId;//'代金券ID'
	
	private String couponName;//'代金券名称'
	
	private String createTime;//'创建时间'
	
	private Integer couponMoney;//'代金券金额'
	
	private Integer sinceMoney;//'条件金额'
	
	private Date beginTime;//'有效开始时间'
	
	private Date endTime;//'有效结束时间'
	
	private String prodTypeId;//'商品类别ID'
	
	private String state;//'有效状态 0.无效 1.有效'
	
	private String adid;//'创建人'
	
	private String couponDesc;//'代金券描述'
	
	private Integer timeLength;//有效天数
	
	
	

	public Integer getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(Integer timeLength) {
		this.timeLength = timeLength;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getCouponMoney() {
		return couponMoney;
	}

	public void setCouponMoney(Integer couponMoney) {
		this.couponMoney = couponMoney;
	}

	public Integer getSinceMoney() {
		return sinceMoney;
	}

	public void setSinceMoney(Integer sinceMoney) {
		this.sinceMoney = sinceMoney;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getProdTypeId() {
		return prodTypeId;
	}

	public void setProdTypeId(String prodTypeId) {
		this.prodTypeId = prodTypeId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAdid() {
		return adid;
	}

	public void setAdid(String adid) {
		this.adid = adid;
	}

	public String getCouponDesc() {
		return couponDesc;
	}

	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}

	
	
}
