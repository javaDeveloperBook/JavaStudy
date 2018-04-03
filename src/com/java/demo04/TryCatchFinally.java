package com.java.demo04;

/**
 * 代码模型05 ： 异常处理模型
 * 
 * @author jack w
 *
 */
class MyMath {
	public static double div(Integer x , Integer y) throws Exception{
		double result = 0;
		try {
			System.out.println("【开始】除法计算开始");
			result = x / y;
		} catch (Exception e) {
			throw e ;
		}finally {
			System.out.println("【结束】除法计算结束");
		}
		return result;
	}
}

public class TryCatchFinally {
	public static void main(String[] args) {
		try {
			System.out.println(MyMath.div(10, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
