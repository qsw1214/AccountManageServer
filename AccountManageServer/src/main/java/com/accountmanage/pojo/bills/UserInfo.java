package com.accountmanage.pojo.bills;

import java.math.BigDecimal;
import java.util.Date;


/**
 * 商户信息表
 * */
public class UserInfo{

	/** 用户ID */
	private String userId;
	
	/** 用户名 */
	private String userName;
	
	/** 登录密码 */
	private String loginPass;
	
	/** 用户状态(0.删除,1.正常) */
	private String state;
	
	/** 手机号 */
	private String telephone;
	
	/** 支付密码 */
	private String payPass;
	
	/** 是否是会员 0.不是 1.是 */
	private String isMember;
	
	/** 用户额度 */
	private BigDecimal amount;
	
	/** 备注 */
	private String remark;
	
	/** 会员折扣 */
	private BigDecimal memRebate;
	
	/** 创建时间 */
	private Date createTime;
	
	/** 设备编号 */
	private String deviceNo;
	
	/**是否是新人**/
	private String isfreshman;//是否为新人 0.不是 1.是'
	
	/**是否购买过一分购产品**/
	private String isOnecent;//是否为新人 0.未购买过一分购 1.是'已购买过一分购
	
	
	
	
	
	
	
	
	public String getIsfreshman() {
		return isfreshman;
	}
	public void setIsfreshman(String isfreshman) {
		this.isfreshman = isfreshman;
	}
	public String getIsOnecent() {
		return isOnecent;
	}
	public void setIsOnecent(String isOnecent) {
		this.isOnecent = isOnecent;
	}
	public String getDeviceNo() {
		return deviceNo;
	}
	public void setDeviceNo(String deviceNo) {
		this.deviceNo = deviceNo;
	}
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPayPass() {
		return payPass;
	}
	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}
	public String getIsMember() {
		return isMember;
	}
	public void setIsMember(String isMember) {
		this.isMember = isMember;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public BigDecimal getMemRebate() {
		return memRebate;
	}
	public void setMemRebate(BigDecimal memRebate) {
		this.memRebate = memRebate;
	}


	
}
