package com.accountmanage.web.kdniao.controller;

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
import com.accountmanage.util.Constants;
import com.accountmanage.util.GsonTools;
import com.accountmanage.util.PropertyManager;
import com.accountmanage.util.vo.BaseReturnMsg;
import com.accountmanage.web.kdniao.network.AbsKdTrade;
import com.accountmanage.web.kdniao.network.KdQueryImmediatelyTrade;
import com.accountmanage.web.kdniao.network.vo.KdBaseRequest;
import com.accountmanage.web.kdniao.network.vo.bean.CommodityBean;
import com.accountmanage.web.kdniao.network.vo.bean.KdSubscriptionReqBean;
import com.accountmanage.web.kdniao.network.vo.bean.ReceiverBean;
import com.accountmanage.web.kdniao.network.vo.bean.SenderBean;

@Controller
@RequestMapping("/kdniao")
@Scope("prototype")
public class KdniaoController {
	
	@Resource
	private IPushOrderService pushOrderService;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/queryimmediately", method = RequestMethod.POST)
	@ResponseBody
	public String queryimmediately(String json,HttpServletRequest request,HttpServletResponse response){
		try{
			/*String shipperCode = "ANE";
			String logisticCode = "210001633605";
			
			KdQueryImmeidatelyReqBean reqBean = new KdQueryImmeidatelyReqBean();
			reqBean.setLogisticCode(shipperCode);
			reqBean.setShipperCode(logisticCode);*/
			
			KdBaseRequest baseReq = new KdBaseRequest();
			baseReq.setRequestData(json);
			baseReq.setReqUrl(PropertyManager.instance()
					.getValue(Constants.KD_PUSH_PROPERTIES, "kdniao_query_immediately"));
			
			
			BaseReturnMsg baseRes = new KdQueryImmediatelyTrade().execute(baseReq);
			
			URLCodec codec = new URLCodec();
			
			return codec.encode(GsonTools.getJsonString(baseRes));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/subscription", method = RequestMethod.POST)
	@ResponseBody
	public String subscription(String json,HttpServletRequest request,HttpServletResponse response){
		try{
			KdSubscriptionReqBean reqBean = new KdSubscriptionReqBean();
			reqBean.setShipperCode("SF");
			reqBean.setOrderCode("SF201608081055208281");
			reqBean.setLogisticCode("3100707578976");
			reqBean.setPayType(1);
			reqBean.setExpType("1");
			reqBean.setCustomerName("");
			reqBean.setCustomerPwd("");
			reqBean.setMonthCode("");
			reqBean.setIsNotice("0");
			
			SenderBean sender = new SenderBean();
			sender.setName("1255760");
			sender.setTel("");
			sender.setMobile("13700000000");
			sender.setProvinceName("广东省");
			sender.setCityName("深圳市");
			sender.setExpAreaName("福田区");
			sender.setAddress("测试地址");
			
			ReceiverBean receiver = new ReceiverBean();
			receiver.setName("1255760");
			receiver.setTel("");
			receiver.setMobile("13800000000");
			receiver.setProvinceName("广东省");
			receiver.setCityName("深圳市");
			receiver.setExpAreaName("龙华新区");
			receiver.setAddress("测试地址2");
			
			CommodityBean commodity = new CommodityBean(); 
			commodity.setGoodsName("书本");
			
			reqBean.setReceiver(receiver);
			reqBean.setSender(sender);
			reqBean.setCommodity(commodity);
			
			

			KdBaseRequest baseReq = new KdBaseRequest();
			baseReq.setRequestData(GsonTools.getJsonString(reqBean));
			baseReq.setReqUrl("http://testapi.kdniao.cc:8081/api/dist");
			
			AbsKdTrade trade = new KdQueryImmediatelyTrade();
			BaseReturnMsg baseRes = trade.execute(baseReq);
			
			return GsonTools.getJsonString(baseRes);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return null;
	}

	@RequestMapping(value = "/kdniaorecv", method = RequestMethod.POST)
	@ResponseBody
	public String doDisposeRecv(HttpServletRequest request, HttpServletResponse response){
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String json = new String(request.getParameter("RequestData")); 
		
		String responseResult = null;
		
		try{
			responseResult = pushOrderService.doKdniaoPushOrder(json);
			
		}catch(Exception ex){
			ex.printStackTrace();
			return "{\"EBusinessID\":1280145,\"UpdateTime\":\"2016-05-11 11:35:09\",\"Success\":true,\"Reason\":\"\"}";
		}
		
		return responseResult;
		
	}

}
