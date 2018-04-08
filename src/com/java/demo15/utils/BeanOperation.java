package com.java.demo15.utils;

public class BeanOperation {
	
	private BeanOperation(){}
	
	/**
	 * 根据字符串设置对象的属性值
	 * @param object
	 * @param value
	 */
	public static void setFeildValue(Object object,String info) {
		String [] fieldStrArr = info.split("\\|");
		for(int i = 0 ; i < fieldStrArr.length ; i++){
			String [] fieldArr = fieldStrArr[i].split(":");
			//两个属性名字符串
			String fieldName = fieldArr[0];
			//设置属性值
			String fieldValue = fieldArr[1];
			String[] fieldTemp = fieldName.split("\\.");
			try {
				Object object2 =  ObjectUtil.getValue(object, fieldTemp[0]);
				ObjectUtil.setValue(object2, fieldTemp[1], fieldValue);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
