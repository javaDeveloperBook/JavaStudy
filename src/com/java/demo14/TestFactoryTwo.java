package com.java.demo14;

/**
 * 测试工厂设计模式第二种实现：使用反射实例化对象
 * 
 * @author jack w
 *
 */
public class TestFactoryTwo {
	public static void main(String[] args) {
		Person person = FactoryTwo.getInstance("com.java.demo14.Student");
		person.eat();
	}
}

/**
 * 第二种工厂类
 *
 */
class FactoryTwo {
	
	private FactoryTwo() {}
	
	public static Person getInstance(String className) {
		Person person = null ;
		try {
			person = (Person)Class.forName(className).newInstance();
		} catch (Exception e) {
		}
		return person;
	}
}

/**
 * 接口
 */
interface Person {
	public void eat();
}

/**
 * 接口实现类
 */
class Student implements Person {

	@Override
	public void eat() {
		System.out.println("【Student】学生进行吃饭");
	}
	
}