package com.accountmanage.web.kdniao.network.vo;

public class KdBaseRequest {

	private String RequestData;//请求内容需进行URL(utf-8)编码。请求内容JSON格式，须和DataType一致。	R
	private String EBusinessID;//商户ID，请在我的服务页面查看。	R
	private String RequestType;//请求指令类型：1002	R
	private String DataSign;//数据内容签名：把(请求内容(未编码)+AppKey)进行MD5加密，然后Base64编码，最后 进行URL(utf-8)编码。详细过程请查看Demo。	R
	private String DataType;//请求、返回数据类型：2-json；
	
	
	private String  reqUrl;
	
	
	
	public String getReqUrl() {
		return reqUrl;
	}
	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}
	public String getRequestData() {
		return RequestData;
	}
	public void setRequestData(String requestData) {
		RequestData = requestData;
	}
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getDataSign() {
		return DataSign;
	}
	public void setDataSign(String dataSign) {
		DataSign = dataSign;
	}
	public String getDataType() {
		return DataType;
	}
	public void setDataType(String dataType) {
		DataType = dataType;
	}
	
	
	
	
}
