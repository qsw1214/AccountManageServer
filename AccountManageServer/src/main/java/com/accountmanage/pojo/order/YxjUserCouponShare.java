package com.accountmanage.pojo.order;

import java.util.Date;

public class YxjUserCouponShare {
	private String shareId;//分享红包主键
	private String baseOrdersn;//总订单号
	private String shareUserId;//分享人ID
	private Date beginTime;//红包起始时间
	private Date endTime;//红包结束时间
	private Integer totalMoney;//红包总金额
	
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public String getBaseOrdersn() {
		return baseOrdersn;
	}
	public void setBaseOrdersn(String baseOrdersn) {
		this.baseOrdersn = baseOrdersn;
	}

	public String getShareUserId() {
		return shareUserId;
	}
	public void setShareUserId(String shareUserId) {
		this.shareUserId = shareUserId;
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
	public Integer getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Integer totalMoney) {
		this.totalMoney = totalMoney;
	}
	
}
