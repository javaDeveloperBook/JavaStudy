package com.java.demo02;

/**
 * 测试对象比较
 * 
 * @author jack w
 *
 */
public class Demo {
	
	public static void main(String[] args) {
		Person personA = new Person("jack w", 10) ;
		Person personB = new Person("jack w",10) ;
		System.out.println(personA.equals(personB));
	}

}
