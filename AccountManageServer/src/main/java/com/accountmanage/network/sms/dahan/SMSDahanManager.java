package com.accountmanage.network.sms.dahan;

import com.accountmanage.network.sms.dahan.vo.DahanResponseVO;
import com.accountmanage.network.util.SMSCode;
import com.accountmanage.util.GsonTools;

public class SMSDahanManager {

	public DahanResponseVO sendSms(String mobiles, String content) throws Exception{
		
		return paseResponseString(SMSDahanSigleSend.send(mobiles, content));
	}
	
	private DahanResponseVO paseResponseString(String str){
		DahanResponseVO vo = new DahanResponseVO();
		
		vo = GsonTools.getSignObject(str, DahanResponseVO.class);
		vo.setSmsCode(getSMSCode(vo.getResult()));
		vo.setStateMsg(getMsg(vo.getResult()));
		return vo;
	}
	
	private SMSCode getSMSCode(String result){
		if("0".equals(result)){
			return SMSCode.COMMITSUCCESS;
		}
		return SMSCode.FAIL;
	}
	
	private String getMsg(String result){
		if("0".equals(result)){
			return "提交成功";
		}
		switch (Integer.parseInt(result)) {
		
		case 1:
			return "账号无效";
		case 2:
			return "密码错误";
		case 3:
			return "msgid太长，不得超过32位";
		case 5:
			return "手机号码个数超过最大限制（500个）";
		case 6:
			return "短信内容超过最大限制（350字）";
		case 7:
			return "扩展号码无效";
		case 8:
			return "定时时间格式错误";
		case 14:
			return "手机号码为空";
		case 19:
			return "用户被禁发或禁用";
		case 20:
			return "ip鉴权失败";
		case 21:
			return "短信内容为空";
		case 22:
			return "数据包大小不匹配";
		case 98:
			return "系统正忙";
		case 99:
			return "消息格式错误";
		default:
			return "未知异常";
		}
	}
	
	public static void main(String []args){
		SMSDahanManager testManager = new SMSDahanManager();
		DahanResponseVO vo = new DahanResponseVO();
		
		try {

			vo = testManager.sendSms("13671277367", "你好，测试短信收一下先！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(vo.getResult());
		
	}
}
