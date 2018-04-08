package com.java.demo15.utils;

/**
 * 根据属性名获取setter/getter方法名
 * 
 * @author jack w
 *
 */
public class StringUtil {

	private StringUtil(){
		
	}
	
	public static String initCat(String fieldName) {
		return fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
	}
}
