package com.accountmanage.pojo.prod;

import com.accountmanage.pojo.bills.UserInfo;

public class CouponUseInfo {

	private String cuid ;//'主键',
	private CouponRuleInfo couponRuleInfo;//'代金券ID',
	private UserInfo userInfo;//用户信息
	private String ordersn ;//'订单号',
	private Integer couponAmount ;//'代金券金额',
	private String state;//'使用状态 1.可使用 2.使用中 3,已使用 4.已过期'
	
	public String getCuid() {
		return cuid;
	}
	public void setCuid(String cuid) {
		this.cuid = cuid;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	
	public CouponRuleInfo getCouponRuleInfo() {
		return couponRuleInfo;
	}
	public void setCouponRuleInfo(CouponRuleInfo couponRuleInfo) {
		this.couponRuleInfo = couponRuleInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Integer getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(Integer couponAmount) {
		this.couponAmount = couponAmount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
