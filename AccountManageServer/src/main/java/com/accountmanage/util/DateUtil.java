package com.accountmanage.util;

import static com.accountmanage.util.DateUtil.toStr;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date Util
 * 
 * @author wangzhj
 */
public final class DateUtil {

	private static final String DEFAULT = "yyyy-MM-dd HH:mm:ss";
	
	private static final String dayFormat = "yyyy-MM-dd";

	private DateUtil() {
		
	}

	/**
	 * 将指定时间转换成字符串
	 * 
	 * @param date
	 * @return String
	 */
	public static String toStr(final Date date) {
		return toStr(date, DEFAULT);
	}

	/**
	 * 将指定时间转换成指定格式的字符串
	 * 
	 * @param date
	 * @return String
	 */
	public static String toStr(final Date date, final String format) {
		if(date == null){
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	
	/**
	 * 将指定时间字符串转换成指定格式的日期
	 * 
	 * @param date
	 * @return String
	 */
	public static Date toDate(final String strDate){
		Date date = toDate(strDate, DEFAULT);
		return date;
	}
	
	/**
	 * 将指定时间字符串转换成日期
	 * 
	 * @param strDate
	 * @return String
	 */
	public static Date toDate(final String strDate, final String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断当前时间
	 * 
	 * @param mix
	 * @param max
	 * @return boolean
	 */
	public static boolean isCurrentHourBetween(final int mix, final int max) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(new Date());
		int hours = ca.get(Calendar.HOUR_OF_DAY);
		if (hours >= mix && hours <= max) {
			return true;
		}
		return false;
	}
	
	/**
	 * 当前时间是否在指定时间区间之内
	 * 
	 * @param begin
	 * @param end
	 * @return boolean
	 */
	public static final boolean isCurrentDateBetween(final Date begin, final Date end) {
		if(!isCurrentDateBefore(begin)){
			return false;
		}
		if(isCurrentDateBefore(end)){
			return false;
		}
		return true;
	}

	/**
	 * 指定时间是否在当前时间之前
	 * 
	 * @param date
	 * @return boolean
	 */
	public static boolean isCurrentDateBefore(final Date date) {
		Date now = new Date();
		return date.before(now);
	}
	
	/**
	 * 获取指定月数前的日期
	 * @param beforeMonth
	 * @return
	 */
	public static String getMothBefore(int beforeMonth){
		SimpleDateFormat sdf = new SimpleDateFormat(dayFormat);
		Calendar newDate = Calendar.getInstance();
		newDate.add(Calendar.MONTH, beforeMonth*-1);
		Date date = newDate.getTime();//获取指定月数前的日期
		return sdf.format(date);
	}
	
	/**
	 * 获取指定天数前的日期
	 * @param beforeMonth
	 * @return
	 */
	public static String getDateBefore(int beforeDate){
		SimpleDateFormat sdf = new SimpleDateFormat(dayFormat);
		Calendar newDate = Calendar.getInstance();
		newDate.add(Calendar.DATE, beforeDate*-1);
		Date date = newDate.getTime();//获取指定天数前的日期
		return sdf.format(date);
	}
	
	/**
	 * 计算指定日期
	 * @param date
	 * @param day
	 * @return Date
	 */
	public static Date nextSomeDay(Date date, int day){
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		ca.add(Calendar.DATE, day);
		return ca.getTime();
	}
	
	/**
	 * 计算指定日期下一天
	 * @param str
	 * @return Date
	 */
	public static Date nextDay(Date date){
		return nextSomeDay(date,1);
	}
	
	public static int CompareTime(String date1,String date2,String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
		try
		{
		c1.setTime(sdf.parse(date1));
		c2.setTime(sdf.parse(date2));
		}catch(java.text.ParseException e){
			System.err.println("格式不正确");
		}
		int result=c1.compareTo(c2);
		/*if(result==0)
			System.out.println("c1相等c2");
		else if(result<0)
			System.out.println("c1小于c2");
		else
			System.out.println("c1大于c2");*/
		return result;
	}
	
	public static void main(String[] args) {
//		String begin = "2015-02-01 00:00:00";
//		String end = "2015-02-08 23:59:59";
		
		String d1 = "16:00";
		String d2 = "04:00";
//		
//		System.out.println(isCurrentDateBetween(toDate(begin), toDate(end)));
		System.out.println(toStr(DateUtil.nextDay(new Date()),"yyyy-MM-dd"));
		System.out.println(CompareTime(d1, d2, "HH:mm"));
	}
}
