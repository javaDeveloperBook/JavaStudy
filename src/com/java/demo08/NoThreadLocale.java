package com.java.demo08;

/**
 * 测试没有使用ThreadLocal时候存在的问题
 * 保存的重要数据会有不同步问题
 * 
 * @author jack w
 *
 */
/**
 * 重要信息实体类 
 */
class Message {
	private String info ;
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
}

class MessageConsumer {
	public void print() {
		System.out.println(Thread.currentThread().getName() + " = " + MyMessageUtil.message.getInfo());
		
	}
}

class MyMessageUtil {
	public static Message message;
	
	public static void setMessage(Message message) {
		MyMessageUtil.message = message;
	}
	public static Message getMessage() {
		return message;
	}
}

public class NoThreadLocale {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Message message = new Message();
				message.setInfo("今天要上班！");
				MyMessageUtil.message = message;
				MessageConsumer messageConsumer = new MessageConsumer();
				messageConsumer.print();
			}
		},"用户A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Message message = new Message();
				message.setInfo("今天不想上班！");
				MyMessageUtil.message = message;
				MessageConsumer messageConsumer = new MessageConsumer();
				messageConsumer.print();
			}
		},"用户B").start();
	}
}
