package com.accountmanage.web.bills.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import base.cn.exception.BaseException;
import base.cn.util.ObjectTools;

import com.accountmanage.service.bills.IBillsHandleService;
import com.accountmanage.web.bills.util.parambean.BUserParam;
import com.accountmanage.web.bills.util.parambean.CUserParam;
import com.accountmanage.web.bills.util.parambean.GiroParam;
import com.accountmanage.web.bills.util.parambean.InsideGiroParam;

public class DisposeCenter {

	private Logger log = Logger.getLogger(this.getClass());
	
	
	/**
	 * 平台账单接收与回复处理
	 * */
	public void disposeBuser(BUserParam buserParam,IBillsHandleService billsHandleService, HttpServletResponse response){
		try {
			
			//校验请求参数BEAN及部分参数有效性
			ValidationCenter validationCenter = new ValidationCenter();
			validationCenter.validateBuserParam(buserParam);
			
			//请求账务处理
			billsHandleService.doBuserBillsHandle(buserParam);
			
			this.sendResponse(response, BillReturnEnum.SUCCESS);
		}catch(BaseException be){
			this.sendResponse(response, be.getReturnEnum());
		} catch (Exception e) {
			BillReturnEnum.FAIL_99.changetMessage(e.getMessage());
			this.sendResponse(response, BillReturnEnum.FAIL_99);
			this.log.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 用户账单接收与回复处理
	 * */
	public void disposeCuser(CUserParam cuserParam,IBillsHandleService billsHandleService, HttpServletResponse response){
		try {
			
			//校验请求参数BEAN及部分参数有效性
			ValidationCenter validationCenter = new ValidationCenter();
			validationCenter.validateCuserParam(cuserParam);
			
			//请求账务处理
			billsHandleService.doCUserBillsHandle(cuserParam);
			
			this.sendResponse(response, BillReturnEnum.SUCCESS);
		}catch(BaseException be){
			this.sendResponse(response, be.getReturnEnum());
		} catch (Exception e) {
			BillReturnEnum.FAIL_99.changetMessage(e.getMessage());
			this.sendResponse(response, BillReturnEnum.FAIL_99);
			this.log.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 用户与平台额度转账接收与回复处理
	 * */
	public void disposeGiro(GiroParam giroParam,IBillsHandleService billsHandleService, HttpServletResponse response){
		try {
			
			//校验请求参数BEAN及部分参数有效性
			ValidationCenter validationCenter = new ValidationCenter();
			validationCenter.validateAmountGiroParam(giroParam);
			
			//请求账务处理
			billsHandleService.doAmountGiroHandle(giroParam);
			
			this.sendResponse(response, BillReturnEnum.SUCCESS);
		}catch(BaseException be){
			this.sendResponse(response, be.getReturnEnum());
		} catch (Exception e) {
			BillReturnEnum.FAIL_99.changetMessage(e.getMessage());
			this.sendResponse(response, BillReturnEnum.FAIL_99);
			this.log.error(e.getMessage(),e);
		}
	}
	
	/**
	 * C类用户与B类用户转账接收与回复处理
	 * */
	public void disposeInsideUserAmountGiro(InsideGiroParam insideGiroParam,IBillsHandleService billsHandleService, HttpServletResponse response){
		try {
			
			//校验请求参数BEAN及部分参数有效性
			ValidationCenter validationCenter = new ValidationCenter();
			validationCenter.validateInsideUserAmountGiroParam(insideGiroParam);
			
			//请求账务处理
			billsHandleService.doinsideGiroUserAmountHandle(insideGiroParam);
			
			this.sendResponse(response, BillReturnEnum.SUCCESS);
		}catch(BaseException be){
			this.sendResponse(response, be.getReturnEnum());
		} catch (Exception e) {
			BillReturnEnum.FAIL_99.changetMessage(e.getMessage());
			this.sendResponse(response, BillReturnEnum.FAIL_99);
			this.log.error(e.getMessage(),e);
		}
	}

		
		private void sendResponse(HttpServletResponse response,BillReturnEnum returnEnum){
			StringBuffer temp = new StringBuffer();
			temp.append("returnCode=");
			temp.append(returnEnum.getCode());
			if(!ObjectTools.isNullByString(returnEnum.getCode().trim())){
				temp.append("&message=");
				temp.append(returnEnum.getMessage());
			}
			this.sendResponseMsg(response, temp.toString());
		}
		
		/**
		 * 发送应答信息
		 * */
		private void sendResponseMsg(HttpServletResponse response,String datas){
			this.log.info("用户账单处理完成,应答字符串:" + datas);
			PrintWriter printWriter = null;
			try {
				response.setCharacterEncoding("UTF-8");
				printWriter = response.getWriter();
				printWriter.write(datas);
				printWriter.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				printWriter.close();
			}
		}
}
