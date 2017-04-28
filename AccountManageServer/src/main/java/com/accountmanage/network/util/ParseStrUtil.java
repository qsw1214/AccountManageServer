package com.accountmanage.network.util;

import java.util.List;


import org.apache.http.NameValuePair;


public class ParseStrUtil {
	
//	组织加密串
	public static String setEncBefore(List<NameValuePair> pairs){
		String encBeforeStr = "";
		if(pairs!=null){
			
		StringBuffer dataBuf = new StringBuffer();
		for(NameValuePair pair:pairs){
			dataBuf.append(pair.getName() + "=" +pair.getValue()+"&");
			
		}
		encBeforeStr = dataBuf.substring(0,dataBuf.length()-1);
		}
		return encBeforeStr;
	}
}
