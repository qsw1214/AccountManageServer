package com.accountmanage.web.kdniao.network.vo.recv;

import java.util.List;

public class KdniaoRequestData {
     private String EBusinessID;
     private String PushTime;
     private String Count;
     private List<RecvDataBean> Data;
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
	public String getPushTime() {
		return PushTime;
	}
	public void setPushTime(String pushTime) {
		PushTime = pushTime;
	}
	public String getCount() {
		return Count;
	}
	public void setCount(String count) {
		Count = count;
	}
	public List<RecvDataBean> getData() {
		return Data;
	}
	public void setData(List<RecvDataBean> data) {
		Data = data;
	}
	
   
     
     
     

     
     
     
     
     
     
}
