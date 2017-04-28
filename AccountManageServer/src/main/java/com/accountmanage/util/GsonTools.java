package com.accountmanage.util;

import com.google.gson.Gson;

/**
 * Gson工具类
 * */
public class GsonTools {

	/**
	 * 将一个对象转换成json字符串
	 * */
	public static String getJsonString(Object obj){
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	/**
	 * 将一个json字符串转化成一个对象
	 * @param <T>
	 * @return 
	 * */
	public static <T> T getSignObject(String jsonString,Class <T>clazz){
		Gson gson = new Gson();
		return gson.fromJson(jsonString, clazz);
	}
	
	public static void main(String []args){
		
	}
}
