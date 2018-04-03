package com.java.demo07;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 代码模型07：日期处理
 * 
 * 1.如何获取当前时间
 * 2.Date类型转long
 * 3.long类型转Date
 * 
 * 4.java.text.simpleDateFormat(核心)
 * 
 * @author jack w
 *
 */
public class TestDateDemo {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		System.out.println("直接输出："+date);
		System.out.println("Date类型变long："+date.getTime());
		System.out.println("long类型变Date"+new Date(date.getTime()));
		
		//日期格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("时间格式化："+sdf.format(date));
		//字符串转时间
		String dateStr = "1993-10-03 18:59:59.111";
		System.out.println("字符串转时间："+sdf.parse(dateStr));
		
	}
}
