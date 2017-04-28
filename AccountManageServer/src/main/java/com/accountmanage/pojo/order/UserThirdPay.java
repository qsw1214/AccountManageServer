package com.accountmanage.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

public class UserThirdPay {

	private String payid;
	private String userid;
	private String ordersn;
	private BigDecimal paymoney;
	private BigDecimal poundage;
	private String thirdordersn;
	private Date paytime;
	private String platform;
	private String partnerid;
	private String state;
     
     
	public String getThirdordersn() {
		return thirdordersn;
	}
	public void setThirdordersn(String thirdordersn) {
		this.thirdordersn = thirdordersn;
	}
	public String getPayid() {
		return payid;
	}
	public void setPayid(String payid) {
		this.payid = payid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	public BigDecimal getPaymoney() {
		return paymoney;
	}
	public void setPaymoney(BigDecimal paymoney) {
		this.paymoney = paymoney;
	}
	public BigDecimal getPoundage() {
		return poundage;
	}
	public void setPoundage(BigDecimal poundage) {
		this.poundage = poundage;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
     
     
     
     
     
     
     
	
     
}
