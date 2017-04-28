package com.accountmanage.pojo.order;

import java.math.BigDecimal;
import java.util.Date;

import com.accountmanage.pojo.bills.BusinessUserInfo;
import com.accountmanage.pojo.bills.UserInfo;

public class BaseOrderInfo {
	 private String baseordersn;//'订单号',
	 private UserInfo userInfo;//'购买用户ID',
	 private BusinessUserInfo businessUser;//'销售商户ID',
	 private BigDecimal primeprice;//'订单未优惠的商品总价',
	 private BigDecimal sellprice;//实际支付价格(包括商品总价-优惠总价+配送费+服务费等)
	 private BigDecimal deliveryfee;//'配送费',
	 private Date ordertime;//'下单时间',
	 private Date paytime;//'支付时间',
	 private Date receivetime;//'到货时间',
	 private String paytype;//'支付方式 1. 微信公众号支付，2. 支付宝支付，3.余额支付,4 微信APP支付
	 private String deviceno;//设备编号',
	 private String distributionInterval;//配送时间段
	 private String orderstate;//'订单状态 0.初始 1.待付款 2.已支付 3.已到货 4.已到货 5.订单取消 6.退货中 7.已退货'
	 private String ordertype;//'订单分类  B.商家端订单 C.用户端订单',
	 private BigDecimal bargainamt;
	 private String sourcetype;
	 private String remark;
	 
	 
	 private String receivename;//'收货人名称',
	 private String receivephone;//'收货人手机号',
	 private String receiveprovince;//'收货省份',
	 private String receivecity;//'收货城市',
	 private String receivedistrict;//'收货区县',
	 private String receiveaddress;//'收货详细地址',
	 
	 
	 
	 
	 
	public String getReceivename() {
		return receivename;
	}
	public void setReceivename(String receivename) {
		this.receivename = receivename;
	}
	public String getReceivephone() {
		return receivephone;
	}
	public void setReceivephone(String receivephone) {
		this.receivephone = receivephone;
	}
	public String getReceiveprovince() {
		return receiveprovince;
	}
	public void setReceiveprovince(String receiveprovince) {
		this.receiveprovince = receiveprovince;
	}
	public String getReceivecity() {
		return receivecity;
	}
	public void setReceivecity(String receivecity) {
		this.receivecity = receivecity;
	}
	public String getReceivedistrict() {
		return receivedistrict;
	}
	public void setReceivedistrict(String receivedistrict) {
		this.receivedistrict = receivedistrict;
	}
	public String getReceiveaddress() {
		return receiveaddress;
	}
	public void setReceiveaddress(String receiveaddress) {
		this.receiveaddress = receiveaddress;
	}
	public String getBaseordersn() {
		return baseordersn;
	}
	public void setBaseordersn(String baseordersn) {
		this.baseordersn = baseordersn;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
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
	public BigDecimal getDeliveryfee() {
		return deliveryfee;
	}
	public void setDeliveryfee(BigDecimal deliveryfee) {
		this.deliveryfee = deliveryfee;
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
	public Date getReceivetime() {
		return receivetime;
	}
	public void setReceivetime(Date receivetime) {
		this.receivetime = receivetime;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getDeviceno() {
		return deviceno;
	}
	public void setDeviceno(String deviceno) {
		this.deviceno = deviceno;
	}
	public String getDistributionInterval() {
		return distributionInterval;
	}
	public void setDistributionInterval(String distributionInterval) {
		this.distributionInterval = distributionInterval;
	}
	public String getOrderstate() {
		return orderstate;
	}
	public void setOrderstate(String orderstate) {
		this.orderstate = orderstate;
	}
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public BigDecimal getBargainamt() {
		return bargainamt;
	}
	public void setBargainamt(BigDecimal bargainamt) {
		this.bargainamt = bargainamt;
	}
	public String getSourcetype() {
		return sourcetype;
	}
	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	 
	 
	 
	 
	 
}
