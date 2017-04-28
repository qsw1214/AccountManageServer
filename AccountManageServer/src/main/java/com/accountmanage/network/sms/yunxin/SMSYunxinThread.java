package com.accountmanage.network.sms.yunxin;

import static com.accountmanage.util.Constants.SMS_PROPERTIES;

import com.accountmanage.network.sms.dahan.SMSDahanSigleSend;
import com.accountmanage.util.PropertyManager;


public class SMSYunxinThread extends Thread {

	
	private String mobiles;
	private String content;
	private String smsType;
	
	public SMSYunxinThread(String smsType,String mobiles,String content){
		this.smsType = smsType;
		this.mobiles = mobiles;
		this.content = content;
	}
	
	@Override
	public void run() {
		
		try {
			
			if(smsType.equals("YX")){
				SMSYunxinManager smsYunxinManager = new SMSYunxinManager();
				smsYunxinManager.send(smsType,mobiles,content+"【优鲜季】");
			}else if(smsType.equals("DH")){
				SMSDahanSigleSend.send(mobiles, content);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		PropertyManager proManager = PropertyManager.instance();
		String content = proManager.getValue(SMS_PROPERTIES,"yunxin.charge.content",true);
		System.out.println(content.replace("@amount@", "66"));
		SMSYunxinThread smsThread = new SMSYunxinThread("",
				"13718989524",content.replace("@amount@", "66"));
		smsThread.start();
		
		
	}
	
}
