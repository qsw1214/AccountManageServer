package com.accountmanage.service.order.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import base.cn.util.IdGenerator;

import com.accountmanage.dao.order.IOrderprocessinfoDAO;
import com.accountmanage.pojo.order.Orderprocessinfo;
import com.accountmanage.service.order.IPushOrderService;
import com.accountmanage.util.GsonTools;
import com.accountmanage.web.kdniao.network.vo.recv.KdniaoRequestData;
import com.accountmanage.web.pinjun.network.util.AESUtil;
import com.accountmanage.web.pinjun.network.vo.tuisong.PjPushTrace;

@Service("pushOrderService")
public class PushOrderServiceImpl implements IPushOrderService{
	
	@Resource
	private IOrderprocessinfoDAO orderprocessinfoDAO;

	
	public String doKdniaoPushOrder(String jsonStr) throws Exception{
		KdniaoRequestData data = GsonTools.getSignObject(jsonStr, KdniaoRequestData.class);
		
		saveProcess(data.getData().get(0).getOrderCode()
				,data.getData().get(0).getTraces().get(0).getAcceptStation()
				, data.getData().get(0).getEstimatedDeliveryTime()
				,data.getData().get(0).getState());
		
		return "{\"EBusinessID\":1280145,\"UpdateTime\":\"2016-05-11 11:35:09\",\" Success\": true,\" Reason\":\"success\"}";
	}

    public String doPjPushOrder(String jsonStr) throws Exception{
    	String acceptJson = AESUtil.aesDecrypt(jsonStr, "41C1069D87C9B714B7D55ED9DDAB1CD0"); 
		PjPushTrace pushTrace = GsonTools.getSignObject(acceptJson, PjPushTrace.class);
		
		saveProcess(pushTrace.getCustOrderNo(), pushTrace.getTransportDetail()
				, pushTrace.getOperateTime(), pushTrace.getOperateType());
		
		
		
		
		return "{\"errCode\": \"true\",\"errMsg\": \"成功\"}";
		
	}
    
    
    private void saveProcess(String ordersn,String processdesc
    		,String processtime,String logisticssstate){
    	Orderprocessinfo orderprocessinfo = new Orderprocessinfo();
	    orderprocessinfo.setOrdersn(ordersn);
	    orderprocessinfo.setProcessdesc(processdesc);
	    orderprocessinfo.setProcessid(IdGenerator.instance().generate(""));
	    orderprocessinfo.setProcesstime(processtime);
	    orderprocessinfo.setLogisticsstate(logisticssstate);
	    orderprocessinfoDAO.insert(orderprocessinfo);
    }


}
