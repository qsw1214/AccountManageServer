package com.accountmanage.web.bills.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintUtil {
	public static String parseGetMethodName(Field field){
		String fieldName=field.getName();
		fieldName=fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
		String temp=null;
		if("boolean".equals(field.getType()+"")){
			temp="is";
		}else{
			temp="get";
		}
		return temp+fieldName;
	}
	public static void printObjectFiled(Object obj){
		Class clazz=obj.getClass();
		Field[] fields=clazz.getDeclaredFields();
		
		for(Field field:fields){
			try {
				Method method=clazz.getDeclaredMethod(parseGetMethodName(field), null);
				System.out.println(field.getName()+"="+method.invoke(obj, null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void printObjectFiled(Class clazz,Object obj){
		
		Field[] fields=clazz.getDeclaredFields();
		
		for(Field field:fields){
			try {
				Method method=clazz.getDeclaredMethod(parseGetMethodName(field), null);
				System.out.println(field.getName()+"="+method.invoke(obj, null));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
