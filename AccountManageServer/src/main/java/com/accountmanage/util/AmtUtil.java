package com.accountmanage.util;

import java.math.BigDecimal;

/**
 * Amt Util
 * 
 * @author xyUser
 */
public final class AmtUtil {

	private AmtUtil() {

	}

	/**
	 * 浮点数加法
	 * 
	 * @param d1 被加数
	 * @param d2 加数
	 * @param double
	 */
	public static double add(final double d1, final double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.add(b2).doubleValue();
	}
	
	/**
	 * 浮点数减法
	 * 
	 * @param d1 被减数
	 * @param d2 减数
	 * @param double
	 */
	public static double subtract(final double d1, final double d2){
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 浮点数乘法
	 * 
	 * @param d1 被乘数
	 * @param d2 乘数
	 * @param double
	 */
	public static double multiply(final double d1, final double d2) {
		BigDecimal b1 = new BigDecimal(Double.toString(d1));
		BigDecimal b2 = new BigDecimal(Double.toString(d2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 浮点数除法
	 * 
	 * @param dividend 被除数
	 * @param divisor  除数
	 * @param double
	 */
	public static double divide(final double dividend, final double divisor) {
		BigDecimal b1 = new BigDecimal(Double.toString(dividend));
		BigDecimal b2 = new BigDecimal(Double.toString(divisor));
		return b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static void main(String[] args) {
		double i = 1;
		int c = 3;
		System.out.println(i/c);
		System.out.println(AmtUtil.divide(i, c));
	}
}
