package com.accountmanage.web.sms.controller;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import base.cn.util.ObjectTools;

import com.accountmanage.network.sms.dahan.SMSDahanManager;
import com.accountmanage.network.sms.dahan.SMSDahanSigleSend;
import com.accountmanage.network.sms.dahan.vo.DahanResponseVO;
import com.accountmanage.network.util.SMSCode;
import com.accountmanage.network.util.SMSNameSuper;
import com.accountmanage.pojo.network.SmsContentInfo;
import com.accountmanage.service.network.ISmsContentInfoService;

@Controller
@RequestMapping("/SmsSend")
@Scope("prototype")
public class DahanSmsSendController {
	
	@Resource
	private ISmsContentInfoService smsContentInfoService;
	
	private SMSNameSuper superName = SMSNameSuper.DAHAN;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/dahanSend", method = RequestMethod.POST)
	public void toSendDispose(String mobiles,String content,String sendType,String userName,HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入大汉短信接口的IP:" + request.getRemoteHost());
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			this.sendDispose(mobiles,content,sendType,userName,request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/batch/dahanSend", method = RequestMethod.POST)
	public void toBatchSendDispose(String mobiles,String content,HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入大汉营销短信接口的IP:" + request.getRemoteHost()+"短信内容:"+mobiles+content);
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			SMSDahanSigleSend.sendBatchSms(mobiles, content);
			
			this.sendResponseMsg(response, "0");
			this.logger.error("营销短信接口发送成功.");
		}catch(Exception e){
			e.printStackTrace();
			this.sendResponseMsg(response, "-1");
		}
	}
	
	/**
	 * 报文接收与回复处理
	 * */
	private void sendDispose(String mobiles,String content,String sendType,String userName,HttpServletRequest request, HttpServletResponse response){		
		
		this.logger.info("短信发送接口接收到内容:mobiles=" + mobiles + ",content=" + content + ",sendType=" + sendType + ",操作人=" + userName);
		
		//信息验证
		if(ObjectTools.isNullByString(mobiles) || ObjectTools.isNullByString(content) || ObjectTools.isNullByString(sendType)){
			this.logger.error("短信接口收到的参数不能为空.");
			this.sendResponseMsg(response, "-1");
			return;
		}
		
		Pattern p = Pattern.compile("\\d{11}(,\\d{11})*");
		Matcher match = p.matcher(mobiles);
		if(!match.matches()){
			this.logger.error("手机号码格式不正确.mobiles = " + mobiles);
			this.sendResponseMsg(response, "-1");
			return;
		}
		
		//初始化短信
		SmsContentInfo sci = new SmsContentInfo();
		try{
			sci = this.smsContentInfoService.saveSmsContentInfo(mobiles, content, sendType, userName, superName.toString());
			//返回接收成功通知
			this.sendResponseMsg(response, "0");
			this.logger.error("短信接口发送成功.");
		}catch(Exception e){
			this.logger.error("短信初始化失败,失败描述:" + e.getMessage(),e.getCause());
			//返回接收失败通知
			this.sendResponseMsg(response, "-1");
			return;
		}
		
		//信息发送处理
		try{
			//发送短信(产品、扩展码可以为空)
			SMSDahanManager smsDahanManager = new SMSDahanManager();
			DahanResponseVO vo = smsDahanManager.sendSms(mobiles, content);
			
			SmsContentInfo updateData = new SmsContentInfo();
			updateData.setStateCode(vo.getResult());
			updateData.setSendTimes(1);
			updateData.setStateMsg(vo.getStateMsg());
			updateData.setMsgId(vo.getMsgid());
			updateData.setCode(vo.getSmsCode().getCode());
			//更新本地数据
			this.smsContentInfoService.EditSmsContentInfo(sci.getSmsId(), updateData);
		}catch(Exception e){
			this.logger.error("短信发送处理失败,短信ID：" + sci.getSmsId() + ",失败描述:" + e.getMessage(),e);
			try{
				SmsContentInfo updateData = new SmsContentInfo();
				updateData.setSendTimes(0);
				updateData.setStateCode("9199");
				updateData.setStateMsg("失败描述:" + e.getMessage());
				updateData.setMsgId("");
				updateData.setCode(SMSCode.FAIL.getCode());
				this.smsContentInfoService.EditSmsContentInfo(sci.getSmsId(), updateData);
			}catch(Exception e1){
				this.logger.error("短信发送处理失败,更新异常,短信ID：" + sci.getSmsId() + ",失败描述:" + e1.getMessage(),e1.getCause());
			}
			return;
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
