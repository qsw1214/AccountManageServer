package com.accountmanage.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tools {
    
	public static byte[] getKeyedDigest(byte[] buffer, byte[] key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(buffer);
            return md5.digest(key);
        } catch (NoSuchAlgorithmException e) {
        }
        return null;
    }
	
		
	public static String getKeyedDigest(String strSrc, String key) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(strSrc.getBytes("UTF8"));
            
            String result="";
            byte[] temp;
            temp=md5.digest(key.getBytes("UTF8"));
    		for (int i=0; i<temp.length; i++){
    			result+=Integer.toHexString((0x000000ff & temp[i]) | 0xffffff00).substring(6);
    		}
    		
    		return result;
    		
        } catch (NoSuchAlgorithmException e) {
        	
        	e.printStackTrace();
        	
        }catch(Exception e)
        {
          e.printStackTrace();
        }
        return null;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String mi;
        String s = "IP=124.205.93.20&app_version=1.0.0&command=1001&imei=792B39D5-C3B0-4ECA-A170-B18E987D2E67&os=wechat&os_version=10.0.2&telephone=15222197160&time_stamp=20161121&userid=";
        
        //第二个参数请填空字符串
		mi=MD5Tools.getKeyedDigest(s,"15222197160");
		
		System.out.println("mi:"+mi);	
	}
}