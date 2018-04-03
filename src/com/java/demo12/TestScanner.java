package com.java.demo12;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 代码模型12:java.util.Scanner测试
 * 
 * 总结：
 * 1.除了二进制文件拷贝之外，只要是针对于信息输出都使用打印流，只要是针对于信息输入都使用Scanner
 * 2.打印流解决OutputStream缺陷，BufferReader解决InputStream缺陷，Scanner解决BufferReader缺陷
 * 
 * @author jack w
 *
 */
public class TestScanner {
	public static void main(String[] args) throws Exception {
//		Scanner scanner = new Scanner(System.in);
		//测试客户输入并回应
//		while (scanner.hasNext()) {
//			System.out.println("ECHO:"+scanner.next());
//		}
		
		//测试不同数据类型输入
//		while (scanner.hasNextInt()) {
//			System.out.println("年龄："+scanner.nextInt());
//		}
		
		//测试自定义分割符
		Scanner scanner1 = new Scanner(new FileInputStream(new File("E:"+File.separator+"1.txt"))); 
		scanner1.useDelimiter("\n");
		while (scanner1.hasNextLine()) {
			System.out.println(scanner1.nextLine());
		}
		
	}
}
