package com.java.test;

/**
 * 阿里云java自测题测试
 * 
 * @author jack w
 *
 */
public class JavaTestError {
	// public static void main(String args[]) {
	// int num = 2147483647 ;
	// num += 2L ;
	// System.out.println(Integer.MAX_VALUE);
	// System.out.println(Integer.MIN_VALUE);
	// System.out.println(num) ;
	// }

	public static void main(String args[]) {
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		int num = 2147483647;
		num += 2;
		System.out.println(num);
	}
}