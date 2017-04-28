package com.accountmanage.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

import com.accountmanage.pojo.bills.UserInfo;

public class YxjUserCouponShareDetail {
	private String detailId;//分享红包明细ID
	private String shareId;//分享红包记录ID
	private UserInfo receiveUser;//领取人ID
	private String couponId;//红包ID
	private String couponTitle;//红包标题
	private BigDecimal couponAmount;//红包面值
	private String couponDesc;//红包描述
	private Date receiveTime;//领取时间
	private String couponName;//红包名称
	private BigDecimal sinceMoney;//条件金额
	private Date beginTime;//生效开始时间
	private Date endTime;//生效结束时间
	
	public String getDetailId() {
		return detailId;
	}
	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public UserInfo getReceiveUser() {
		return receiveUser;
	}
	public void setReceiveUser(UserInfo receiveUser) {
		this.receiveUser = receiveUser;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	
	public String getCouponTitle() {
		return couponTitle;
	}
	public void setCouponTitle(String couponTitle) {
		this.couponTitle = couponTitle;
	}
	public BigDecimal getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}
	
	public String getCouponDesc() {
		return couponDesc;
	}
	public void setCouponDesc(String couponDesc) {
		this.couponDesc = couponDesc;
	}
	public Date getReceiveTime() {
		return receiveTime;
	}
	public void setReceiveTime(Date receiveTime) {
		this.receiveTime = receiveTime;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public BigDecimal getSinceMoney() {
		return sinceMoney;
	}
	public void setSinceMoney(BigDecimal sinceMoney) {
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
	
}
