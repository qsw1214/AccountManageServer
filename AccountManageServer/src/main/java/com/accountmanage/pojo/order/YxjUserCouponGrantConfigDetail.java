package com.accountmanage.pojo.order;

import com.accountmanage.pojo.prod.CouponRuleInfo;


public class YxjUserCouponGrantConfigDetail {
	private String grantconfigDetailId;
	private YxjUserCouponGrantConfig grantconfig;
	private CouponRuleInfo couponRuleInfo;
	private int grantQuantity;
	public String getGrantconfigDetailId() {
		return grantconfigDetailId;
	}
	public void setGrantconfigDetailId(String grantconfigDetailId) {
		this.grantconfigDetailId = grantconfigDetailId;
	}
	public YxjUserCouponGrantConfig getGrantconfig() {
		return grantconfig;
	}
	public void setGrantconfig(YxjUserCouponGrantConfig grantconfig) {
		this.grantconfig = grantconfig;
	}
	
	public CouponRuleInfo getCouponRuleInfo() {
		return couponRuleInfo;
	}
	public void setCouponRuleInfo(CouponRuleInfo couponRuleInfo) {
		this.couponRuleInfo = couponRuleInfo;
	}
	public int getGrantQuantity() {
		return grantQuantity;
	}
	public void setGrantQuantity(int grantQuantity) {
		this.grantQuantity = grantQuantity;
	}

	
	
	
}
