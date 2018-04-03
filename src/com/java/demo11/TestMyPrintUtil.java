package com.java.demo11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 测试自定义的打印输出流
 * @author jack w
 *
 */
public class TestMyPrintUtil {
	
	public static void main(String[] args) {
		try {
			OutputStream outputStream = new FileOutputStream(new File("E:"+File.separator+"1.txt"));
			MyPrintUtil myPrintUtil = new MyPrintUtil(outputStream);
			myPrintUtil.print("Hello World");
			myPrintUtil.println("Jack wu");
			myPrintUtil.prinln(12);
			myPrintUtil.prinln(12.00);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

/**
 * 打印流基础模型<br>
 * 自定义打印类<br>
 * 原理是：封装OutputStream功能，并扩展打印String 、 int、double等类型的数据
 */
class MyPrintUtil {
	/**
	 * 外部传入打印输出流，方便各种打印输出流的实现
	 */
	private OutputStream outputStream ;
	
	public MyPrintUtil(OutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public void print(String str) {
		try {
			this.outputStream.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void println(String str) {
		this.print(str+"\r\n");
	}
	
	public void print(int data) {
		this.print(String.valueOf(data));
	}
	
	public void prinln(int data) {
		this.println(String.valueOf(data));
	}
	public void print(double data) {
		this.print(String.valueOf(data));
	}
	
	public void prinln(double data) {
		this.println(String.valueOf(data));
	}
}