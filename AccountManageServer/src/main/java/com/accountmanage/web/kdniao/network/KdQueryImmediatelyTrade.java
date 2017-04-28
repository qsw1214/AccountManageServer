package com.accountmanage.web.kdniao.network;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.accountmanage.util.Base64Util;
import com.accountmanage.util.Constants;
import com.accountmanage.util.GsonTools;
import com.accountmanage.util.MD5Tools;
import com.accountmanage.util.PropertyManager;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.util.vo.orderprocess.OrderProcessBean;
import com.accountmanage.util.vo.orderprocess.OrderProcessReturnMsg;
import com.accountmanage.web.kdniao.network.vo.KdBaseRequest;
import com.accountmanage.web.kdniao.network.vo.KdQueryImmediatelyResponse;
import com.accountmanage.web.kdniao.network.vo.bean.TracesBean;

public class KdQueryImmediatelyTrade extends AbsKdTrade {

	@Override
	protected List<NameValuePair> getRequestParams(KdBaseRequest request)
			throws Exception {
		PropertyManager pm = PropertyManager.instance();
		
		

		List<NameValuePair> tempPairs = new ArrayList<NameValuePair>();
		
		tempPairs.add(new BasicNameValuePair("RequestData",request.getRequestData()));
		tempPairs.add(new BasicNameValuePair("EBusinessID",pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_EBusinessID")));
		tempPairs.add(new BasicNameValuePair("RequestType","1002"));
		String md5String = MD5Tools.getKeyedDigest(request.getRequestData(), pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_appkey"));
		tempPairs.add(new BasicNameValuePair("DataSign",Base64Util.Encode(md5String)));
		tempPairs.add(new BasicNameValuePair("DataType",pm.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_dataType")));
		
		return tempPairs;
	}

	@Override
	protected BaseReturnMsg toParseResponse(String responseString)
			throws Exception {
		
		OrderProcessReturnMsg returnMsg = new OrderProcessReturnMsg();
		
		if(responseString!=null && !"".equals(responseString) && responseString.startsWith("{")){
			KdQueryImmediatelyResponse response = GsonTools.getSignObject(responseString, KdQueryImmediatelyResponse.class);
			returnMsg.setSuccess(response.getSuccess());
			if(response.getSuccess()){
				returnMsg.setLogisticsstate(kdniaoConvertLogistcState(response.getState()));
				returnMsg.setWaybillno(response.getLogisticCode());
				returnMsg.setOrdersn(response.getOrderCode());
				
				List<OrderProcessBean> processlist = new ArrayList<OrderProcessBean>();
				OrderProcessBean processBean = null;
				for(TracesBean trace:response.getTraces()){
					processBean = new OrderProcessBean();
					processBean.setProcessdesc(trace.getAcceptStation());
					processBean.setProcessremark(trace.getRemark());
					processBean.setProcesstime(trace.getAcceptTime());
					
					processlist.add(processBean);
				}
				returnMsg.setProcesslist(processlist);
			}else{
				returnMsg.setMessage(response.getReason());
			}
			
	    }else{
	    	returnMsg.setSuccess(false);
			returnMsg.setMessage("网络连接错误");
	    }
		
		return returnMsg;
	}
	
	public static String kdniaoConvertLogistcState(String state){
		// 2-在途中，3-签收,4-问题件
		String  retState = null;
		switch(state){
			case "2":
				retState = "4";
				break;
			case "3":
				retState = "5";
				break;
			case "4":
				retState = "6";
				break;
		}
		
		return retState;
			
	}

	
	
	
	
	
}
