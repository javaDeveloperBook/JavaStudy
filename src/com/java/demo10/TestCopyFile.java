package com.java.demo10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 测试文件拷贝
 * 
 * @author jack w
 *
 */
public class TestCopyFile {

	public static void main(String[] args) {
		String srcPath = "E:"+ File.separator + "timg.jpg";
		String dicPath = "E:"+ File.separator + "a" + File.separator +"1.jpg";
		
		if (CopyUtil.fileExists(srcPath)) {
			if (!CopyUtil.fileExists(dicPath)) {
				CopyUtil.createParentFile(dicPath);
			}
			if (CopyUtil.copyFile(srcPath, dicPath)) {
				System.out.println("文件拷贝成功");
			}else {
				System.out.println("文件拷贝失败");
			}
		}else {
			System.out.println("源文件不存在！");
		}
	}
}

/**
 * 文件拷贝程序工具类 
 */
class CopyUtil {
	
	/**
	 * 私有化构造函数，不让产生对象
	 */
	private CopyUtil() {
		
	}
	
	/**
	 * 判断源文件路径是否存在
	 * @param path 源文件路径
	 * @return 如果源文件存在则返回true,否则返回false
	 */
	public static boolean fileExists(String path) {
		return new File(path).exists();
	}
	
	/**
	 * 判断目标文件父路径是否存在，如果不存在则创建父路径
	 * @param path 目标文件路径
	 */
	public static void createParentFile(String path) {
		File file = new File(path);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
	}
	
	/**
	 * 根据源文件路径和目标文件路径进行文件拷贝
	 * @param srcPath 源文件路径
	 * @param dirPath 目标文件路径
	 * @return 如果文件拷贝成功则返回true，否则返回false
	 */
	public static boolean copyFile(String srcPath , String dirPath) {
		boolean flag = false;
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		try {
			inputStream = new FileInputStream(new File(srcPath));
			outputStream  = new FileOutputStream(new File(dirPath));
			copyHandle(inputStream, outputStream);
			flag = true ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag ;
	}
	
	/**
	 * 根据传入的输入流和输出流进行文件拷贝
	 * @param inputStream 输入流
	 * @param outputStream 输出流
	 * @throws IOException IO异常
	 */
	private static void copyHandle(InputStream inputStream , OutputStream outputStream) throws IOException {
		long start = System.currentTimeMillis();
		//开辟一个字节数组进行暂存读取的输入流
		byte[] temp = new byte[2048];
		//保存每次读取输入流的个数
		int len = 0;
		while ((len = inputStream.read(temp)) != -1) {
			outputStream.write(temp,0,len);
		}
		long end = System.currentTimeMillis();
		System.out.println("拷贝文件所花费时间："+(end-start));

	}
	
}
