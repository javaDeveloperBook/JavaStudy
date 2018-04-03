package com.java.demo05;

/**
 * 测试自定义链表
 * 
 * @author jack w
 *
 */
public class TestLinkNode {
	
	public static void main(String[] args) {
		Link myLink = new MyLink();
		System.out.println(myLink.size()+" = "+ myLink.isEmpty());
		myLink.add("jack");
		myLink.add("haha");
		myLink.add("AA");
		System.out.println(myLink.size()+" = "+ myLink.isEmpty());
		
		System.out.println("===============================");
		
		Object[] datas = myLink.toArray();
		for(int i = 0 ; i < datas.length ;i++) {
			System.out.println(datas[i]);
		}
		
		System.out.println("===============================");
		
		System.out.println(myLink.contains("jack"));
		System.out.println(myLink.contains("XXX"));
		
		System.out.println("===============================");
		System.out.println(myLink.get(1));
		
		
		System.out.println("=================测试修改索引对应的值==============");
		myLink.set(1, "newJack");
		Object[] datas1 = myLink.toArray();
		for(int i = 0 ; i < datas1.length ;i++) {
			System.out.println(datas1[i]);
		}
		
		System.out.println("=================删除链表==============");
		System.out.println(myLink.remove("jack"));
		Object[] datas2 = myLink.toArray();
		for(int i = 0 ; i < datas2.length ;i++) {
			System.out.println(datas2[i]);
		}
		
	}
	

}
