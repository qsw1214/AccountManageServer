package com.accountmanage.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

import com.accountmanage.pojo.bills.BusinessUserInfo;
import com.accountmanage.pojo.bills.UserInfo;

public class OrderInfo {

	 public String ordersn;//'订单号',
	 public UserInfo userInfo;//'购买用户ID',
	 public BusinessUserInfo businessUser;//'销售商户ID',
	 public BigDecimal primeprice;//'订单原价',
	 public BigDecimal sellprice;//'订单售价',
	 public BigDecimal successprice;//转账金额
	 public BigDecimal deductamt;//'满减金额',
	 public BigDecimal firstorderamt;//'首单立减金额',
	 public BigDecimal couponamt;//'代金券金额',
	 public BigDecimal deliveryfee;//'配送费',
	 public BigDecimal servicefee;//'服务费',
	 public Date ordertime;//'下单时间',
	 public Date paytime;//'支付时间',
	 public String payflag;//'配送标记 1.配送 2.自取',
	 public String paytype;//'支付方式 1. 微信支付，2. 支付宝支付，3.余额支付
	 public String couponflag;//'使用优惠券标记 0.未使用 1.已使用',
	 public String receivetelephone;//'收货人手机号',
	 public String receivename;//'收货人姓名',
	 public String receiveaddress;//'收货人地址',
	 public Date receivetime;//'到货时间',
	 public String deviceno;//设备编号',
	 public String remark;//'订单备注',
	 public String orderstate;//'订单状态 0.初始 1.待付款 2.已支付 3.已到货 4.已到货 5.订单取消 6.退货中 7.已退货
	 /**是否是一份购订单**/
	 private String isOnecent;//是否为新人 0.不是 1.是
	 
	 
	 
	 
	 public String getIsOnecent() {
		return isOnecent;
	}
	public void setIsOnecent(String isOnecent) {
		this.isOnecent = isOnecent;
	}
	public BigDecimal getSuccessprice() {
		return successprice;
	}
	public void setSuccessprice(BigDecimal successprice) {
		this.successprice = successprice;
	}
	public UserInfo getUserInfo() {
			return userInfo;
		}
		public void setUserInfo(UserInfo userInfo) {
			this.userInfo = userInfo;
		}
		
	public String getOrdersn() {
		return ordersn;
	}
	public void setOrdersn(String ordersn) {
		this.ordersn = ordersn;
	}
	
	public BusinessUserInfo getBusinessUser() {
		return businessUser;
	}
	public void setBusinessUser(BusinessUserInfo businessUser) {
		this.businessUser = businessUser;
	}
	public BigDecimal getPrimeprice() {
		return primeprice;
	}
	public void setPrimeprice(BigDecimal primeprice) {
		this.primeprice = primeprice;
	}
	public BigDecimal getSellprice() {
		return sellprice;
	}
	public void setSellprice(BigDecimal sellprice) {
		this.sellprice = sellprice;
	}
	public BigDecimal getDeductamt() {
		return deductamt;
	}
	public void setDeductamt(BigDecimal deductamt) {
		this.deductamt = deductamt;
	}
	public BigDecimal getFirstorderamt() {
		return firstorderamt;
	}
	public void setFirstorderamt(BigDecimal firstorderamt) {
		this.firstorderamt = firstorderamt;
	}
	public BigDecimal getCouponamt() {
		return couponamt;
	}
	public void setCouponamt(BigDecimal couponamt) {
		this.couponamt = couponamt;
	}
	public BigDecimal getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(BigDecimal deliveryfee) {
		this.deliveryfee = deliveryfee;
	}
	public BigDecimal getServicefee() {
		return servicefee;
	}
	public void setServicefee(BigDecimal servicefee) {
		this.servicefee = servicefee;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public String getPayflag() {
		return payflag;
	}
	public void setPayflag(String payflag) {
		this.payflag = payflag;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getCouponflag() {
		return couponflag;
	}
	public void setCouponflag(String couponflag) {
		this.couponflag = couponflag;
	}
	public String getReceivetelephone() {
		return receivetelephone;
	}
	public void setReceivetelephone(String receivetelephone) {
		this.receivetelephone = receivetelephone;
	}
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getReceiveaddress() {
		return receiveaddress;
	}
	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}
	public Date getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	public String getDeviceno() {
		return deviceno;
	}
	public void setDeviceno(String deviceno) {
		this.deviceno = deviceno;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	




}
