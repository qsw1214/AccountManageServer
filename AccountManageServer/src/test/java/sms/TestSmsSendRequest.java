package sms;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import bills.HttpTools;

public class TestSmsSendRequest {
	
	public static void  main(String[] args){
		
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
		formparams.add(new BasicNameValuePair("mobiles", "13671277367")); 
		formparams.add(new BasicNameValuePair("content", "你好，测试短信收一下先！")); 
		formparams.add(new BasicNameValuePair("sendType", "0"));
		
		String url = "http://localhost:7856/AccountManageServer/SmsSend/dahanSend";
		
		HttpTools tools = new HttpTools();
		try {
			String str = tools.excute(url,formparams);
			System.out.println(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
