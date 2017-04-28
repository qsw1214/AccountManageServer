package com.accountmanage.pojo.bills;

import java.util.Date;

public class WeChatUserInfo {

	private String wetchid;//'微信用户ID',
	private String openid;//'微信OPENID',
	private String userid;//'用户ID',
	private String nickname;//'昵称',
	private Integer sex;//'性别 0.未知 1.男 2.女',
	private String city;//'城市',
	private String country;//'国家',
	private String province;//'省份',
	private String language;//'语言',
	private String headimgurl;//'头像URL',
	private Date subscribetime;//'最后一次关注事件',
	private String isbunding;//'是否绑定 0.未绑定 1.已绑定',
	private String isunsubscribe;//'是否取消关注 0.未取消 1.已取消',
	private Date unsubscribetime;//'取消关注时间',
	
	public String getWetchid() {
		return wetchid;
	}
	public void setWetchid(String wetchid) {
		this.wetchid = wetchid;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public Date getSubscribetime() {
		return subscribetime;
	}
	public void setSubscribetime(Date subscribetime) {
		this.subscribetime = subscribetime;
	}
	public String getIsbunding() {
		return isbunding;
	}
	public void setIsbunding(String isbunding) {
		this.isbunding = isbunding;
	}
	public String getIsunsubscribe() {
		return isunsubscribe;
	}
	public void setIsunsubscribe(String isunsubscribe) {
		this.isunsubscribe = isunsubscribe;
	}
	public Date getUnsubscribetime() {
		return unsubscribetime;
	}
	public void setUnsubscribetime(Date unsubscribetime) {
		this.unsubscribetime = unsubscribetime;
	}
	
	
	
	
}
