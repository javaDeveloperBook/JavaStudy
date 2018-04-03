package com.java.demo11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 测试使用打印流：PrintStream 、 PrintWriter<br>
 * 
 * 1.PrintStream 可以接收OutputStream ;PrintWriter 则可以接收OutputStream和Writer<br>
 * 2.打印流的设计模式是装饰设计模式<br>
 * 
 * @author jack w
 *
 */
public class TestPrintStreamAndPrintWriter {
	public static void main(String[] args) {
		FileOutputStream out = null;
		PrintWriter printWriter = null;
		try {
			out = new FileOutputStream(new File("E:"+File.separator+"1.txt"));
			printWriter = new PrintWriter(out);
			//打印流的格式化操作，顺便也测试了一下String类的格式化操作
			String name = "jack w";
			int age = 24;
			double salary = 6000.00;
			String str = String.format("姓名：%s\r\n年龄：%d\r\n工资：%f", name,age,salary);
			printWriter.write(str);
			printWriter.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
