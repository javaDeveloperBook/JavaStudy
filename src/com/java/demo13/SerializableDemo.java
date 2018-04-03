package com.java.demo13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 代码模型13：序列化和反序列化
 * 
 * 方法：
 * 1.序列化使用的是 ：ObjectOutputStream
 * 2.反序列化使用的是：ObjectInputStream
 * 
 * @author jack w
 *
 */
public class SerializableDemo {
	
	private static File FILE = new File("E:"+File.separator+"person.ser");
	
	public static void main(String[] args) throws Exception {
//		ser(new Person("jack w", 24));
		dser(FILE);
	}
	
	/**
	 * 序列化方法
	 * @param object 需要序列化的对象
	 * @throws IOException 异常
	 */
	public static void ser(Object object) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE));
		oos.writeObject(object);
		System.out.println("序列化成功！");
		oos.close();
	}
	
	/**
	 * 反序列化方法
	 * @param file  
	 * @throws Exception
	 */
	public static void dser(File file) throws Exception {
		ObjectInputStream ooi = new ObjectInputStream(new FileInputStream(FILE));
		System.out.println(ooi.readObject());
		System.out.println("反序列化成功！");
		ooi.close();
	}
}

/**
 * 测试序列化和反序列化的实体类 
 * 
 */
class Person implements Serializable {
	/**
	 * 序列化版本号，用于JDK 1.8序列化的对象使用 JDK 1.8反序列化使用
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
}
