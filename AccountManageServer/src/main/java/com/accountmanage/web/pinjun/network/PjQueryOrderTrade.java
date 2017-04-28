package com.accountmanage.web.pinjun.network;

import java.util.ArrayList;
import java.util.List;

import com.accountmanage.util.GsonTools;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.util.vo.orderprocess.OrderProcessBean;
import com.accountmanage.util.vo.orderprocess.OrderProcessReturnMsg;
import com.accountmanage.web.pinjun.network.vo.PjQueryOrderResponse;
import com.accountmanage.web.pinjun.network.vo.PjRequestConfig;
import com.accountmanage.web.pinjun.network.vo.bean.PjTraceBean;

public class PjQueryOrderTrade extends PjAbsTrade {

	@Override
	protected String getRequestParams(PjRequestConfig requestConfig)
			throws Exception {
		
		return requestConfig.getBusinessData();
	}

	@Override
	protected BaseReturnMsg toParseResponse(String responseString)
			throws Exception {

		OrderProcessReturnMsg returnMsg = new OrderProcessReturnMsg();
		
		if(responseString!=null && !"".equals(responseString) && responseString.startsWith("{")){
			PjQueryOrderResponse response = GsonTools.getSignObject(responseString, PjQueryOrderResponse.class);

			returnMsg.setSuccess("0".equals(response.getReturnCode())?true:false);
			if(response.getResult().getStatus() == null){
				returnMsg.setMessage("暂无此单号信息");
			}else{
				returnMsg.setLogisticsstate(pjConvertLogistcState(response.getResult().getStatus()));
				returnMsg.setWaybillno(response.getResult().getTransportNo());
				
				List<OrderProcessBean> processlist = new ArrayList<OrderProcessBean>();
				OrderProcessBean processBean = null;
				if(response.getResult() != null && response.getResult().getTraceList() != null){
					for(PjTraceBean trace:response.getResult().getTraceList()){
						processBean = new OrderProcessBean();
						processBean.setProcessdesc(trace.getStatusDesc());
						processBean.setProcessremark(trace.getStatusAddress());
						processBean.setProcesstime(trace.getStatusTime());
						processlist.add(processBean);
					}
					returnMsg.setProcesslist(processlist);
				}
				
			}
			
	    }else{
			returnMsg.setSuccess(false);
			returnMsg.setMessage("网络连接错误");
	    }
		
		return returnMsg;
	}
	
	
	public static String pjConvertLogistcState(String state){
		  /*已创建
			已揽收
			在途
			派送中
			签收
			拒收
			退货
			退货成功*/

		String  retState = null;
		if("已创建".equals(state) || "已揽收".equals(state)){
			retState = "3";
		}else if("在途".equals(state) || 
				 "派送中".equals(state) ){
			retState = "4";
		}else if("签收".equals(state)){
			retState = "5";
		}else if("拒收".equals(state) || 
				 "退货".equals(state) || 
				 "退货成功".equals(state) ||
				 "丢失".equals(state) ||
				 "弃货处理".equals(state)){
			retState = "6";
		}
		
		return retState;
			
	}

	
	
}
