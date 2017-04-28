package com.accountmanage.pojo.system;

public class SubStoreInfo {

	private String storeid;//'分库ID',
	private String storename;//'分库名称',
	private String longitude;//'经度坐标',
	private String latitude;//'纬度坐标',
	private Integer radius;//'搜索半径',
	private String remark;//'备注',
	
	public String getStoreid() {
		return storeid;
	}
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Integer getRadius() {
		return radius;
	}
	public void setRadius(Integer radius) {
		this.radius = radius;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}


	
}
