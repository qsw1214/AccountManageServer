package com.accountmanage.web.pinjun.network.vo.bean;

import java.util.List;

public class PjQueryOrderBean {

    private String transportNo;
    private String status;
    private List<PjTraceBean> traceList;
    
	public String getTransportNo() {
		return transportNo;
	}
	public void setTransportNo(String transportNo) {
		this.transportNo = transportNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<PjTraceBean> getTraceList() {
		return traceList;
	}
	public void setTraceList(List<PjTraceBean> traceList) {
		this.traceList = traceList;
	}
    
    
    
    
    
	
}
