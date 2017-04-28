package com.accountmanage.pojo.network;

import java.math.BigDecimal;
import java.util.Date;

public class SmsContentInfo {

	/* 短信信息ID */
	private String smsId;
	
	/* 手机号码 */
	private String mobiles;
	
	/* 手机号数量 */
	private Integer mobileNums;
	
	/* 短信内容 */
	private String content;
	
	/* 短信类型（15.普通短信 8.长短信） */
	private String contentType;
	
	/* 接收时间 */
	private Date notifyDatetime;
	
	/* 发送次数 */
	private Integer sendTimes;
	
	/* 发送时间 */
	private Date sendDatetime;
	
	/* 状态码 */
	private String stateCode;
	
	/* 状态描述 */
	private String stateMsg;
	
	/* 发送类型 0.自动 1.手动 */
	private String sendType;
	
	/* 操作用户名 */
	private String userName;
	
	/* 费用 */
	private BigDecimal money;
	
	/* 第三方返回记录ID */
	private String msgId;
	
	/* 第三方短信渠道名称 */
	private String superName;
	
	/* 本地记录状态 0.初始化 1. 提交成功 2.发送成功 3.发送失败*/
	private String code;
	
	/* 短信序列号  */
	private String seq;

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}

	public String getMobiles() {
		return mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;
	}

	public Integer getMobileNums() {
		return mobileNums;
	}

	public void setMobileNums(Integer mobileNums) {
		this.mobileNums = mobileNums;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Date getNotifyDatetime() {
		return notifyDatetime;
	}

	public void setNotifyDatetime(Date notifyDatetime) {
		this.notifyDatetime = notifyDatetime;
	}

	public Integer getSendTimes() {
		return sendTimes;
	}

	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}

	public Date getSendDatetime() {
		return sendDatetime;
	}

	public void setSendDatetime(Date sendDatetime) {
		this.sendDatetime = sendDatetime;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateMsg() {
		return stateMsg;
	}

	public void setStateMsg(String stateMsg) {
		this.stateMsg = stateMsg;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getMoney() {
		return money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getSuperName() {
		return superName;
	}

	public void setSuperName(String superName) {
		this.superName = superName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
}
