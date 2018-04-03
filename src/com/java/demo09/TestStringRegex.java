package com.java.demo09;

import java.text.SimpleDateFormat;

/**
 * String类对正则支持五个方法：
 * 1.public boolean matches(String regex) 匹配正则
 * 2.public String replaceAll(String regex, String replacement) 根据正则规则进行替换全部
 * 3.public String replaceFirst(String regex, String replacement) 根据正则替换第一个匹配的字符
 * 4.public String[] split(String regex) 根据正则规则进行拆分
 * 5.public String[] split(String regex, int limit) 根据正则规则进行拆分，并且有限制拆分的长度
 * 
 * @author jack w
 *
 */
public class TestStringRegex {

	public static void main(String[] args) throws Exception {
		//1.提取出字母
		String str = "saosas63823njneife*(*()kjskd";
		String regex = "[^a-zA-Z]";
		System.out.println(str.replaceAll(regex , ""));
		//2.字符串拆分
		String str2 = "a1b22c333d4444e55555f";
		//只能是\\d+ ,不能是\\d* 或 \\d
		String[] result = str2.split("\\d+");
		for(int i = 0; i < result.length ; i++) {
			System.out.println(result[i]);
		}
		
		System.out.println("**********验证字符串************");
		
		//3.判断一个字符串是否是数字，如果是数字则转换成double类型
		String str3 = "1100.12";
		String regexDouble = "\\d+(\\.\\d+)?";
		if (str3.matches(regexDouble)) {
			double d = Double.parseDouble(str3);
			System.out.println(d);
		}
		
		System.out.println("**********判断日期时间格式字符串，并转换成Date类型************");
		String str4 = "2018-01-01" ;
		String str5 = "2018-01-01 23:59:59";
		String regex4 = "\\d{4}-\\d{2}-\\d{2}";
		String regex5 = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
		if (str4.matches(regex4)) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd").parse(str4));
		}
		if (str5.matches(regex5)) {
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str5));
		}
		System.out.println("**********判断电话号码是否正确************");
		//电话号码格式一：47755765 或88888888 ，基本是7位或8位
		//电话号码格式二： 01088888888 ，带3位或4位区号
		//电话号码格式三：(010)-88888888，特殊带区号格式
		String regexTelephone1 = "\\d{7,8}";
		System.out.println("47755765".matches(regexTelephone1));
		System.out.println("88888888".matches(regexTelephone1));
		
		String regexTelephone2 = "(\\d{3,4})?\\d{7,8}";
		System.out.println("01088888888".matches(regexTelephone2));
		
		String regexTelephone3 = "((\\(\\d{3,4}\\)-)|(\\d{3,4}))?\\d{7,8}";
		System.out.println("88888888".matches(regexTelephone3));
		System.out.println("01088888888".matches(regexTelephone3));
		System.out.println("(010)-88888888".matches(regexTelephone3));
		
		System.out.println("**********验证邮箱************");
		String regexEmail = "[a-zA-Z][a-zA-Z_\\-\\.0-9]*@[a-zA-Z_\\-\\.0-9]*\\.(cn|com|gov|org|com\\.cn)";
		System.out.println("wujie278_java-kaka@qq.com".matches(regexEmail));
	}
}
