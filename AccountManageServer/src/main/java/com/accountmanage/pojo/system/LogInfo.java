package com.accountmanage.pojo.system;

import java.util.Date;

public class LogInfo {
   
	private String id;
	private String operateModule;
	private String operateMethod;
	private String parameters;//传入参数
	private String operator;//操作人
	private Date operateTime;//操作时间
	private String reqIp;//请求IP
	private String exceptionDesc;
	private String exceptionAddr;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOperateModule() {
		return operateModule;
	}
	public void setOperateModule(String operateModule) {
		this.operateModule = operateModule;
	}
	public String getOperateMethod() {
		return operateMethod;
	}
	public void setOperateMethod(String operateMethod) {
		this.operateMethod = operateMethod;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Date operateTime) {
		this.operateTime = operateTime;
	}
	public String getReqIp() {
		return reqIp;
	}
	public void setReqIp(String reqIp) {
		this.reqIp = reqIp;
	}
	public String getExceptionDesc() {
		return exceptionDesc;
	}
	public void setExceptionDesc(String exceptionDesc) {
		this.exceptionDesc = exceptionDesc;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public String getExceptionAddr() {
		return exceptionAddr;
	}
	public void setExceptionAddr(String exceptionAddr) {
		this.exceptionAddr = exceptionAddr;
	}
	
	
}