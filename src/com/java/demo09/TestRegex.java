package com.java.demo09;

/**
 * 正则表达式的测试类
 * 
 * 正则标记，全部都在java.util.regex.Pattern中定义：
 * 
 * 【单个】描述单个字符
 * 1. x  : 就是任意一个字符，匹配同样的字符
 * 2. \\ : 匹配\，注意正则表达式要写成四个斜杠\\\\
 * 3. \t : 描述的是制表符
 * 4. \n : 描述的是换行
 * 
 * 【单个】描述一个范围
 * 1.[abc] : 描述a、b、c范围之中
 * 2.[^abc]: 描述不在abc范围之中
 * 3.[0-9] : 描述数字在0~9之中
 * 4.[a-zA-Z] : 描述字符在a~z和A~Z之中的一个 
 * 
 * 【单个】简化表达式
 * 1. . : 表示任意一位字符，可以匹配 .、a、... ；但是 . 和  \\. 是不同意思
 * 2.\d : 等价于 [0-9],表示任意一位数字
 * 3.\D : 等价于[^0-9],表示任意的非数字
 * 4.\s : 表示一位空格，可能是空格、\t、\n
 * 5.\S ：  表示不是一位空格，
 * 6.\w : 等价于[a-zA-Z0-9_]，表示字母、数字、下划线
 * 7.\W : 等价于[^a-zA-Z0-9_]，表示不是字母、数字、下划线
 * 
 * 边界匹配（java用不上，javascript用得上）
 * ^ : 表示开始
 * $ : 表示结束
 * 
 * 数量表达，重复出现n次需要加上数量表达
 * 1. ? : 表示该匹配出现0次或1次
 * 2. + ：表示该匹配出现1次或多次
 * 3. * : 表示该匹配出现0次、1次、多次
 * 4. {n} : 表示该匹配只能是n次
 * 5. {n,} : 表示该匹配出现大于等于n次，包括n次
 * 6. {n,m} : 表示该匹配出现 n ~ m 次
 * 
 * 逻辑匹配
 * 正则A正则B : 就表示与的关系，在第一个匹配之后马上匹配第二个正则表达式
 * 正则A|正则B : 表示A或B正则出现一次，竖线前后不能加空格
 * (正则) : 按照一组正则进行处理
 * 
 *  
 * @author jack w
 *
 */
public class TestRegex {
	public static void main(String[] args) {
		
		System.out.println("a".matches("a"));
		System.out.println("aa".matches("a"));
		
		//第一个双斜杠是因为第一个斜杠转移第二个斜杠
		//第二个四斜杠是因为在正则表达式中一个双斜杠才代表一个斜杠，而匹配一个斜杠需要两个斜杠，所以有四个斜杠
		System.out.println("\\".matches("\\\\"));
		
		System.out.println("	".matches("\\t"));
		
		System.out.println("\n".matches("\\n"));
		
		System.out.println("*************************");
		
		System.out.println("a".matches("[abc]"));
		
		System.out.println("a".matches("[^abc]"));
		
		System.out.println("1".matches("[0-9]"));
		
		System.out.println("c".matches("[a-zA-Z]"));
		
		System.out.println("*************************");
		
		System.out.println("a".matches("."));
		System.out.println("a".matches("\\."));
		
		System.out.println("9".matches("\\d"));
		System.out.println("9".matches("\\D"));
		
		System.out.println("\t".matches("\\s"));
		System.out.println(" ".matches("\\s"));
		System.out.println("\n".matches("\\s"));
		
		System.out.println(" ".matches("\\S"));
		
		System.out.println("_".matches("\\w"));
		System.out.println("a".matches("\\w"));
		System.out.println("3".matches("\\w"));
		
		System.out.println("_".matches("\\W"));
		
		System.out.println("*************************");
		
		System.out.println("a".matches("a?"));
		System.out.println("".matches("a?"));
		
		System.out.println("a".matches("a+"));
		System.out.println("aaa".matches("a+"));
		
		System.out.println("".matches("a*"));
		System.out.println("a".matches("a*"));
		System.out.println("aaaa".matches("a*"));
		
		
		System.out.println("aaaaa".matches("a{5}"));
		System.out.println("aaaaaa".matches("a{5,}"));
		System.out.println("aaaaaa".matches("a{5,10}"));
		
	}
}
