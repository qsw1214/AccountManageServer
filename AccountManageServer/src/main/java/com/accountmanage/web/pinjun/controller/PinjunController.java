package com.accountmanage.web.pinjun.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.net.URLCodec;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accountmanage.service.order.IPushOrderService;
import com.accountmanage.util.GsonTools;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.pinjun.network.PjQueryOrderTrade;
import com.accountmanage.web.pinjun.network.vo.PjRequestConfig;

@Controller
@RequestMapping("/pinjun")
@Scope("prototype")
public class PinjunController {
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@Resource
	private IPushOrderService pushOrderService;

	@RequestMapping(value = "/querytrace", method = RequestMethod.POST)
	@ResponseBody
	public String querytrace(String json,HttpServletRequest request,HttpServletResponse response) throws Exception{
		URLCodec codec = new URLCodec();
		
		try{
			//PjQueryOrderRequest queryReq = new PjQueryOrderRequest();
//			/queryReq.setOrderSn(request.getParameter("json"));
			
			PjRequestConfig reqConfig = new PjRequestConfig(
					"pjbest.logistics.order.DeliveryOrderService",
					"getDeliveryOrderTraceByOrderSn", 
					json);
		
			BaseReturnMsg baseRes = new PjQueryOrderTrade().execute(reqConfig);
			
			
			return codec.encode(GsonTools.getJsonString(baseRes));
			
		}catch(Exception e){
			
			e.printStackTrace();
			BaseReturnMsg baseRes = new BaseReturnMsg(false, "未知异常");
			return codec.encode(GsonTools.getJsonString(baseRes));
		}
		
	}
	
	
	@RequestMapping(value = "/recvtrace", method = RequestMethod.POST)
	@ResponseBody
	public String disposePushTrace(String encryptStr,HttpServletRequest request,HttpServletResponse response){
		String retJson=null;
		
		try{
			
			
			 retJson = pushOrderService.doPjPushOrder(encryptStr);
			
			
		}catch(Exception e){
			e.printStackTrace();
			return "{\"errCode\": \"false\",\"errMsg\": \"处理异常\"}";
		}
		
		return retJson;
	}
	
}
