package com.java.demo14;

/**
 * 代码模型14：工厂设计模式<br>
 * 
 * 最简单工厂设计模式实现
 * 
 * @author jack w
 *
 */
public class TestFactoryOne {
	public static void main(String[] args) {
		IFruit apple = FactoryOne.getInstance("apple");
		apple.eat();
	}
}

/**
 * 简单的工厂方法
 * 
 */
class FactoryOne {
	
	private FactoryOne() {}
	
	public static IFruit getInstance(String className) {
		if ("apple".equals(className)) {
			return new Apple();
		}
		return null;
	}
	
}

/**
 * 工厂模式的接口
 */
interface IFruit {
	public void eat();
}

/**
 * 工厂模式的实现类
 */
class Apple implements IFruit {

	@Override
	public void eat() {
		System.out.println("【Apple】吃苹果");
	}
	
}

