package com.accountmanage.util;

import base.cn.util.ObjectTools;



/**
 * 数字与byte数组转换工具
 * <p>1. byte的大小为8 bits.</P>
 * <p>2. short的大小为16 bits.</P>
 * <p>3. int的大小为32 bits.</P>
 * <p>4. long的大小为64 bits.</P>
 * */
public class ByteUtil {
	
	/**
	 * 将short类型转为byte数组
	 * */
	public static byte[] short2ByteArray(short value){
		return short2ByteArray(value, new byte[2], 0);
	}
	
	/**
	 * 将short类型转为指定长度的byte数组
	 * 
	 * @param value short类型数值
	 * @param b 转换后生成的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static byte[] short2ByteArray(short value, byte []b, int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 2) ? 2 : (b.length - offset);
		
		for(int i = 0; i < length; i ++){
			b[offset + i] = (byte)((value >> (8 * (length - i - 1))) & 0xFF);
		}

		return b;
	}
	
	/**
	 * 将byte数组转换为short数值
	 * 
	 * @param b 需要被转换的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static short byteArray2Short(byte []b, int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 2) ? 2 : (b.length - offset);
		short t = 0;
		for(int i = 0; i < length; i ++){
			t += (b[offset + i] & 0xFF) << (8 * (length - i - 1)) ;
		}
		return t;
	}
	
	/**
	 * 将int类型转为byte数组
	 * */
	public static byte[] int2ByteArray(int value){
		return int2ByteArray(value, new byte[4], 0);
	}

	/**
	 * 将int类型转为指定长度的byte数组
	 * 
	 * @param value int类型数值
	 * @param b 转换后生成的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static byte[] int2ByteArray(int value, byte []b , int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 4) ? 4 : (b.length - offset);
		
		for(int i = 0; i < length; i ++){
			b[offset + i] = (byte)((value >> (8 * (length - i - 1))) & 0xFF);
		}

		return b;
	}
	
	/**
	 * 将byte数组转换为int数值
	 * 
	 * @param b 需要被转换的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static int byteArray2Int(byte []b, int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 4) ? 4 : (b.length - offset);
		int t = 0;
		for(int i = 0; i < length; i ++){
			t += (b[offset + i] & 0xFF) << (8 * (length - i - 1)) ;
		}
		return t;
	}
	
	/**
	 * 将long类型转为byte数组
	 * */
	public static byte[] long2ByteArray(long value){
		return long2ByteArray(value, new byte[8], 0);
	}
	
	/**
	 * 将long类型转为指定长度的byte数组
	 * 
	 * @param value long类型数值
	 * @param b 转换后生成的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static byte[] long2ByteArray(long value, byte []b , int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 8) ? 8 : (b.length - offset);
		
		for(int i = 0; i < length; i ++){
			b[offset + i] = (byte)((value >> (8 * (length - i - 1))) & 0xFF);
		}

		return b;
	}
	
	/**
	 * 将byte数组转换为long数值
	 * 
	 * @param b 需要被转换的byte数组
	 * @param offset byte数组偏移量
	 * */
	public static long byteArray2Long(byte []b, int offset){
		if(ObjectTools.isNullByObject(b)){
			throw new RuntimeException("byte数组不能为空.");
		}
		if(offset < 0 ){
			throw new RuntimeException("偏移量不能小于0.");
		}
		
		int length = ((b.length - offset) > 8) ? 8 : (b.length - offset);
		long t = 0;
		for(int i = 0; i < length; i ++){
			t += (long)(b[offset + i] & 0xFF) << (8 * (length - i - 1)) ;
		}
		return t;
	}
	
	/**
	 * 删除字符串中的结束符
	 * */
	public static String getString(String str){
		byte[] bbs = {(byte)0x00};
		return str.replaceAll(new String(bbs), "");
	}
	
	public static void main(String []args){
		short st = 12;
		byte []sbt = ByteUtil.short2ByteArray(st);
		for(int i = 0; i < sbt.length; i ++){
			System.out.println(sbt[i]);
		}
		
		System.out.println("==" + ByteUtil.byteArray2Short(sbt, 1));
		
		System.out.println("------------------------------------");
		
		int t = 1223456789;
		byte[] bt = ByteUtil.int2ByteArray(t);
		for(int i = 0; i < bt.length; i ++){
			System.out.println(bt[i]);
		}
		
		System.out.println("==" + ByteUtil.byteArray2Int(bt, 0));
		
		
		System.out.println("------------------------------------");
		
		long lt = 1223456789098769876L;
		byte[] lbt = ByteUtil.long2ByteArray(lt);
		for(int i = 0; i < lbt.length; i ++){
			System.out.println(lbt[i]);
		}
		
		System.out.println("==" + ByteUtil.byteArray2Long(lbt, 0));
		
		
	}
}
