package com.java.demo15.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 
 * 利用反射进行属性值的取得和设置
 * @author jack w
 *
 */
public class ObjectUtil {
	private ObjectUtil(){}
	
	/**
	 * 为某个对象根据属性设置值
	 * @param object
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	public static void setValue(Object object,String fieldName,String value) throws Exception {
		String methodName = "set"+StringUtil.initCat(fieldName);
		Field field = object.getClass().getDeclaredField(fieldName);
		if (null == field) {
			field = object.getClass().getField(fieldName);
		}
		Method method = object.getClass().getMethod(methodName, field.getType());
		method.invoke(object, value);
	}
	
	/**
	 * 取得某个对象的属性对象
	 * @param object
	 * @param field
	 * @return
	 * @throws Exception 
	 */
	public static Object getValue(Object object,String fieldName) throws Exception {
		String methodName = "get"+StringUtil.initCat(fieldName);
		Method method = object.getClass().getMethod(methodName);
		return method.invoke(object);
	}
	
}
