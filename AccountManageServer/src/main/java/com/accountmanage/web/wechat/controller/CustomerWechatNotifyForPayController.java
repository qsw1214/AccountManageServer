package com.accountmanage.web.wechat.controller;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.cn.util.ObjectTools;

import com.accountmanage.service.wechat.CustomerWechatNotifyForPayService;



/**
 * 订单支付微信回调通知
 * @author rg
 */
@Controller
@RequestMapping("/customerwechat")
public class CustomerWechatNotifyForPayController {

	@Resource
	private CustomerWechatNotifyForPayService customerWechatNotifyForPayService;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/forpay", method = RequestMethod.POST)
	public void toSendDispose(HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入微信订单支付接口的IP:" + request.getRemoteHost());
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			this.doDispose(request, response);
		}catch(Exception e){
			this.sendResponseMsg(response, "1");
			e.printStackTrace();
		}
	}
	
	/**
	 * 报文接收与回复处理
	 * */
	private void doDispose(HttpServletRequest request, HttpServletResponse response) throws Exception{		
		String orderSn = request.getParameter("orderSn");
		String third_no = request.getParameter("third_no");
		if(ObjectTools.isNullByString(orderSn) || ObjectTools.isNullByString(third_no)){
			this.sendResponseMsg(response, "1");
		}else{
			customerWechatNotifyForPayService.doWechatNotifyForPay(orderSn,third_no);
			this.sendResponseMsg(response, "0");
		}
		
		
	}
	
	/**
	 * 发送应答信息
	 * */
	private void sendResponseMsg(HttpServletResponse response,String state){
		PrintWriter printWriter = null;
		try {
			printWriter = response.getWriter();
			printWriter.write(state);
			printWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			printWriter.close();
		}
	}
	
	
	
	
	
	
}
