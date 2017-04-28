package com.accountmanage.web.sms.controller;

import java.io.PrintWriter;
import java.util.Date;
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

import com.accountmanage.network.sms.yunxin.SMSYunxinManager;
import com.accountmanage.network.sms.yunxin.SMSYunxinSendVO;
import com.accountmanage.network.util.SMSCode;
import com.accountmanage.network.util.SMSNameSuper;
import com.accountmanage.pojo.network.SmsContentInfo;
import com.accountmanage.service.network.ISmsContentInfoService;

import base.cn.util.ObjectTools;

@Controller
@RequestMapping("/SmsSend")
@Scope("prototype")
public class YunXinSmsSendController {

	@Resource
	private ISmsContentInfoService smsContentInfoService;
	
	private SMSNameSuper superName = SMSNameSuper.YUNXIN;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	@RequestMapping(value = "/yunxinSend", method = RequestMethod.POST)
	public void toSendDispose(String mobiles,String content,String sendType,String userName,HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入云信短信接口的IP:" + request.getRemoteHost());
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			this.sendDispose(mobiles,content,sendType,userName,request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 报文接收与回复处理
	 * */
	private void sendDispose(String mobiles,String content,String sendType,String userName,HttpServletRequest request, HttpServletResponse response){		
		
		//添加后置签名
		content = content+"【优鲜季】";
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
			SMSYunxinManager smsYunxinManager = new SMSYunxinManager();
			SMSYunxinSendVO vo = smsYunxinManager.send("YX",mobiles, content);
			
			SmsContentInfo updateData = new SmsContentInfo();
			updateData.setStateCode(vo.getRespStatus());
			updateData.setSendTimes(1);
			updateData.setStateMsg(vo.getStateMsg());
			updateData.setMsgId(vo.getMsgID());
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
	
	
	
	
	
	
	
	@RequestMapping(value = "/yunxinRecieveNotify", method = RequestMethod.POST)
	public void toNotifyDispose(String account,String GetReport,HttpServletRequest request,HttpServletResponse response){
		this.logger.info("接入云信O短信状态接口的IP:" + request.getRemoteHost());
		try{
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			this.notifyDispose(account,GetReport,request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 报文接收与回复处理
	 * */
	private void notifyDispose(String account,String GetReport,HttpServletRequest request, HttpServletResponse response){
		//account账号
		//GetReport接收状态报告验证的密码,可以为空
		String[] getReportArr = GetReport.split("\\|");
       
		try{
			for(int i=0;i<getReportArr.length;i++){
				 String[] arr = getReportArr[i].split("\\,");
				 SmsContentInfo smsContentInfo = this.smsContentInfoService.getByMsgId(arr[0]);
				 if("DELIVRD".equals(arr[2])){
						smsContentInfo.setStateCode("00");
						smsContentInfo.setStateMsg("短信状态通知：成功 "+getStatsMsg(arr[2]));
						smsContentInfo.setCode(SMSCode.SENDOVER.getCode());
						smsContentInfo.setNotifyDatetime(new Date());
						
					} else {
						smsContentInfo.setStateCode("99");
						smsContentInfo.setStateMsg("短信状态通知：失败 "+getStatsMsg(arr[2]));
						smsContentInfo.setCode(SMSCode.FAIL.getCode());
						smsContentInfo.setNotifyDatetime(new Date());
						
					}
				this.smsContentInfoService.EditSmsContentInfo(smsContentInfo.getSmsId(), smsContentInfo);
			}
		}catch(Exception e){
			logger.error("云信短信状态报告异常!", e);
		}
	}
	
	private String getStatsMsg(String status){
		if("DELIVRD".equals(status)){
			return "短消息转发成功";
		}
		if("EXPIRED".equals(status)){
			return "短消息超过有效期";
		}
		if("UNDELIV".equals(status)){
			return "短消息是不可达的";
		}
		if("UNKNOWN".equals(status)){
			return "未知短消息状态";
		}
		if("REJECTD".equals(status)){
			return "短消息被短信中心拒绝";
		}
		if("DTBLACK".equals(status)){
			return "目的号码是黑名单号码";
		}
		if("ERR:104".equals(status)){
			return "系统忙";
		}
		if("REJECT".equals(status)){
			return "审核驳回";
		}
		if("其他".equals(status)){
			return "网关内部状态";
		}
		return "未定义状态";
	}
	
	private boolean getDispose(String status){
		if("DELIVRD".equals(status)){
			return true;
		}
		
		return false;
	}
	
}
