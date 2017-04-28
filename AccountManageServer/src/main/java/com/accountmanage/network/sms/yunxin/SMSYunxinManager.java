package com.accountmanage.network.sms.yunxin;

import com.accountmanage.network.util.SMSCode;


public class SMSYunxinManager {

	public SMSYunxinSendVO send(String smsType,String mobiles, String content)throws Exception{
		return paseResponseString(SMSYunxinUtil.send(smsType,mobiles, content));
	}
	
	
	private SMSYunxinSendVO paseResponseString(String str){
		SMSYunxinSendVO vo = new SMSYunxinSendVO();
		
		vo.setSendTime(null);
		if(Long.parseLong(str) > 0){
			vo.setMsgID(str);
			vo.setRespStatus("1");
		}else{
			vo.setRespStatus(str);
		}
		
		vo.setStateMsg(getMsg(str));
		vo.setSmsCode(getSMSCode(str));
		return vo;
	}
	
	private SMSCode getSMSCode(String code){
		if(Long.parseLong(code) > 0){
			return SMSCode.COMMITSUCCESS;
		}
		return SMSCode.FAIL;
	}
	
	private String getMsg(String code){
		if(Long.parseLong(code) > 0){
			return "提交成功";
		}
		switch (Integer.parseInt(code)) {
		case 0:
			return "程序出现其他异常";
		case -1:
			return "提交接口错误";
		case -3:
			return "用户名或密码错误";
		case -4:
			return "短信内容和备案模板不一样";
		case -5:
			return "签名不正确";
		case -7:
			return "余额不足";
		case -8:
			return "通道错误";
		case -9:
			return "无效号码";
		case -10:
			return "签名内容不符合长度";
		case -11:
			return "用户有效期过期";
		case -12:
			return "黑名单";
		case -13:
			return "语音验证码的Amount参数必须是整形字符串";
		case -14:
			return "语音验证码的内容只能为数字";
		case -15:
			return "语音验证码的内容最长为6位";
		case -16:
			return "余额请求过于频繁，5秒才能取余额一次";
		default:
			return "未知异常";
		}
	}
}
