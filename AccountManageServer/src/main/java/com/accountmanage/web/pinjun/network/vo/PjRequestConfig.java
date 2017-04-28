package com.accountmanage.web.pinjun.network.vo;

import com.accountmanage.util.Constants;
import com.accountmanage.util.PropertyManager;

public class PjRequestConfig {

    private String format;
	private String appKey;
	private String service;
	private String method;
	private String timestamp;
	private String version;
	private String appSecrect;
	private String url;
	private String businessData;
	
	public PjRequestConfig(String service,String method,String businessData){
		PropertyManager pm = PropertyManager.instance();
		
		this.appSecrect = pm.getValue(Constants.KD_PUSH_PROPERTIES, "pj_appSecrect");
		this.url = pm.getValue(Constants.KD_PUSH_PROPERTIES, "pj_query_url");
		this.businessData = businessData;
		
		
		
		this.format = pm.getValue(Constants.KD_PUSH_PROPERTIES, "pj_format");
		this.version = pm.getValue(Constants.KD_PUSH_PROPERTIES, "pj_version");
		this.service = service;
		this.method = method;
		this.timestamp = String.valueOf(System.currentTimeMillis()/1000);
		this.appKey = pm.getValue(Constants.KD_PUSH_PROPERTIES, "pj_appkey");
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getAppSecrect() {
		return appSecrect;
	}
	public void setAppSecrect(String appSecrect) {
		this.appSecrect = appSecrect;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBusinessData() {
		return businessData;
	}
	public void setBusinessData(String businessData) {
		this.businessData = businessData;
	}
	
	
	
	
	
	
}
