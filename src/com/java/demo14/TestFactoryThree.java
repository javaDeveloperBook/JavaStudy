package com.java.demo14;

/**
 * 工厂设计模式三：使用反射和泛型进行工厂类实现
 * 
 * 总结： 反射可以解决同一接口的不同实现类的实例化对象，而泛型解决不同接口的实现类使用同一工厂类进行实例化对象
 * 
 * @author jack w
 *
 */
public class TestFactoryThree {
	public static void main(String[] args) {
		Animal animal = FactoryThree.getInstance("com.java.demo14.Cat");
		animal.eat();
		
		Message message = FactoryThree.getInstance("com.java.demo14.QQMessage");
		message.print();
	}
}

/**
 * 终极版的工厂设计模式类
 */
class FactoryThree {
	
	private FactoryThree() {}
	
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className) {
		T obj = null;
		try {
			obj = (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}

/**
 * 动物接口
 */
interface Animal {
	public void eat();
}

/**
 * 狗狗实现类
 */
class Dog implements Animal {

	@Override
	public void eat() {
		System.out.println("【Dog】狗狗吃肉肉");
	}
	
}

/**
 * 猫咪实现类
 */
class Cat implements Animal {

	@Override
	public void eat() {
		System.out.println("【Cat】猫咪吃猫粮");
	}
	
}

/**
 * 信息接口
 */
interface Message {
	public void print();
}

class QQMessage implements Message {

	@Override
	public void print() {
		System.out.println("【QQMessage】打印QQ信息");
	}
	
}