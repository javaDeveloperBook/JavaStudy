package com.java.demo09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用java.util.regex中的类进行正则开发
 * 
 * 
 * 
 * @author jack w
 *
 */
public class TestJavaUtilRegex {

	public static void main(String[] args) {
		//1.使用Pattern类进行切割
		System.out.println("************使用Pattern进行正则切割***********");
		Pattern pattern = Pattern.compile(",");
		String[] result = pattern.split("1,2,3,4");
		for(int i = 0 ; i < result.length ; i++) {
			System.out.println(result[i]);
		}
		
		//2.使用Pattern类和Matcher类进行正则匹配
		System.out.println("************使用Pattern类和Matcher类进行正则匹配***********");
		Pattern pattern2 = Pattern.compile("\\d+");
		Matcher matcher = pattern2.matcher("888");
		System.out.println(matcher.matches());
		
		//3.做复杂的正则匹配，String类完成不了的正则匹配
		System.out.println("************使用Pattern类和Matcher类进行复杂的正则匹配***********");
		String sql = "INSERT INTO user (userid,name) VALUES (#{user.id},#{user.name})";
		Pattern pattern3 = Pattern.compile("#\\{[a-zA-Z\\.]+\\}");
		Matcher matcher2 = pattern3.matcher(sql);
		while(matcher2.find()){
			System.out.println(matcher2.group(0));
		}
	}
}
