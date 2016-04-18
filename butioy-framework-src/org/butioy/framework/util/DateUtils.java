package org.butioy.framework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: 日期处理工具类 
 * @ClassName: DateUtils
 * @author: lqyang
 * @date: 2014年11月15日 下午7:15:19

 * @version: 1.0
 */
public class DateUtils {

	public static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static final String FULL_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static final String TIME_FORMAT = "HH:mm:ss";
	
	/**
	 * @Description: 时间戳转Date类型 
	 * @Title: longToDate
	 * @param timestamp 时间戳
	 * @return Date类型对象
	 */
	public static Date longToDate( Long timestamp ) {
		return null != timestamp ? new Date(timestamp) : null;
	}
	
	/**
	 * @Description: 日期格式字符串转Date类型 
	 * @Title: stringToDate
	 * @param dateString 日期格式字符串
	 * @return Date类型对象
	 */
	public static Date stringToDate( String dateString ) {
		return stringToDate(dateString, null);
	}
	
	/**
	 * @Description: 把指定格式的日期字符串转成Date类型 
	 * @Title: stringToDate
	 * @param dateString 日期字符串
	 * @param format 指定格式
	 * @return Date类型对象
	 */
	public static Date stringToDate( String dateString, String format ) {
		if( StringUtils.isBlank(dateString) ) return null;
		if( StringUtils.isBlank(format) ) format = DEFAULT_FORMAT;
		DateFormat df = new SimpleDateFormat(format);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @Description: Date类型转成字符串 
	 * @Title: dateToString
	 * @param date Date类型对象
	 * @return 格式化后的日期字符串
	 */
	public static String dateToString( Date date ) {
		return dateToString(date, null);
	}
	
	/**
	 * @Description: Date类型转成指定格式字符串 
	 * @Title: dateToString
	 * @param date Date类型对象
	 * @param format 指定格式
	 * @return 格式化后的日期字符串
	 */
	public static String dateToString( Date date, String format ) {
		if( null == date ) return "";
		if( StringUtils.isBlank(format) ) format = DEFAULT_FORMAT;
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	/**
	 * @Description: 日期字符串转成时间戳 
	 * @Title: stringToLong
	 * @param dateStr 日期字符串
	 * @return 时间戳
	 */
	public static Long stringToLong( String dateStr ) {
		return stringToLong( dateStr, null );
	}
	
	/**
	 * @Description: 指定格式的日期字符串转成时间戳 
	 * @Title: stringToLong
	 * @param dateStr 日期字符串
	 * @param format 指定格式
	 * @return 时间戳
	 */
	public static Long stringToLong( String dateStr, String format ) {
		if( StringUtils.isBlank(dateStr) ) return null;
		if( StringUtils.isBlank(format) ) format = DEFAULT_FORMAT;
		Date date = stringToDate(dateStr, format);
		return null == date ? null : date.getTime();
	}
	
}
