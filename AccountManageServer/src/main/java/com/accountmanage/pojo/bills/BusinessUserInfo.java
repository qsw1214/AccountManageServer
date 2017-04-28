package com.accountmanage.pojo.bills;

import java.math.BigDecimal;

public class BusinessUserInfo {

	/** 商户ID */
	private String buserId;
	
	/** 商户名称 */
	private String buserName;
	
	/** 商户额度 */
	private BigDecimal amount;
	
	/** 登录密码 */
	private String loginPass;
	
	/** 代金券额度 */
	private BigDecimal couponAmount;
	
	/** 商户状态 0.删除 1.正常 */
	private String state;
	
	/** 备注 */
	private String remark;
	
	private String preselltime;
	//预售时间

	public String getBuserId() {
		return buserId;
	}

	public void setBuserId(String buserId) {
		this.buserId = buserId;
	}

	public String getBuserName() {
		return buserName;
	}

	public void setBuserName(String buserName) {
		this.buserName = buserName;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getLoginPass() {
		return loginPass;
	}

	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}

	public BigDecimal getCouponAmount() {
		return couponAmount;
	}

	public void setCouponAmount(BigDecimal couponAmount) {
		this.couponAmount = couponAmount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getPreselltime() {
		return preselltime;
	}

	public void setPreselltime(String preselltime) {
		this.preselltime = preselltime;
	}
	
	
	
}
