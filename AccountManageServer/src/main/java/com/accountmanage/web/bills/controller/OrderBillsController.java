package com.accountmanage.web.bills.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accountmanage.service.bills.IBillsHandleService;
import com.accountmanage.util.GsonTools;
import com.accountmanage.web.bills.util.DisposeCenter;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

@Controller
@RequestMapping("/orderBills")
@Scope("prototype")
public class OrderBillsController {
	
	@Resource
	private IBillsHandleService billsHandleService;
	
	private Logger logger = Logger.getLogger(this.getClass());

	@RequestMapping(value = "/buserBillsControl", method = RequestMethod.POST)
	public void buserDispose(String json_buserBills,HttpServletRequest request,HttpServletResponse response){
		try{
			BUserParam buserParam = null;
			
			logger.info("进入商户账务中心开始处理...");
			
			buserParam =  GsonTools.getSignObject(json_buserBills, BUserParam.class);
			DisposeCenter disposeCenter = new DisposeCenter();
			
			disposeCenter.disposeBuser(buserParam,billsHandleService, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/cuserBillsControl", method = RequestMethod.POST)
	public void cuserDispose(String json_cuserBills,HttpServletRequest request,HttpServletResponse response){
		try{
			CUserParam cuserParam = null;
			
			logger.info("进入用户账务中心开始处理...");
			
			cuserParam =  GsonTools.getSignObject(json_cuserBills, CUserParam.class);
			DisposeCenter disposeCenter = new DisposeCenter();
			
			disposeCenter.disposeCuser(cuserParam,billsHandleService, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/giroBillsControl", method = RequestMethod.POST)
	public void giroDispose(String json_giroBills,HttpServletRequest request,HttpServletResponse response){
		try{
			GiroParam giroParam = null;
			
			logger.info("进入用户账务中心开始处理...");
			
			giroParam =  GsonTools.getSignObject(json_giroBills, GiroParam.class);
			DisposeCenter disposeCenter = new DisposeCenter();
			
			disposeCenter.disposeGiro(giroParam,billsHandleService, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/insideGiroBillsControl", method = RequestMethod.POST)
	public void insideUserAmountGiroDispose(String json_insideUserAmountGiroBills,HttpServletRequest request,HttpServletResponse response){
		try{
			InsideGiroParam insideGiroParam = null;
			
			logger.info("进入用户账务中心开始处理...");
			
			insideGiroParam =  GsonTools.getSignObject(json_insideUserAmountGiroBills, InsideGiroParam.class);
			DisposeCenter disposeCenter = new DisposeCenter();
			
			disposeCenter.disposeInsideUserAmountGiro(insideGiroParam, billsHandleService, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	

}
