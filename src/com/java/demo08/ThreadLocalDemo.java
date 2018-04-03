package com.java.demo08;

/**
 * 使用ThreadLocal类例子
 * 让不同线程设置和获取自己线程的数据
 * 原理是：ThreadLocal在保存数据的时候还保存了线程名用于区分不同线程
 * @author jack w
 *
 */

class MessageTwo {
	private String info ;
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfo() {
		return info;
	}
}

class MessageConsumerTwo {
	public void print() {
		System.out.println( Thread.currentThread().getName() + " = " + MyThreadLocalUtil.get().getInfo() );
	}
}

class MyThreadLocalUtil {
	private static ThreadLocal<Message> threadLocal = new ThreadLocal<>();
	public static void set(Message message) {
		threadLocal.set(message);
	}
	public static Message get() {
		return threadLocal.get();
	}
}

public class ThreadLocalDemo {
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Message message = new Message();
				message.setInfo("今天要上班");
				MyThreadLocalUtil.set(message);
				MessageConsumerTwo mTwo = new MessageConsumerTwo();
				mTwo.print();
			}
		},"线程A").start();
		new Thread(new Runnable() {
			@Override
			public void run() {
				Message message = new Message();
				message.setInfo("今天不想上班");
				MyThreadLocalUtil.set(message);
				MessageConsumerTwo mTwo = new MessageConsumerTwo();
				mTwo.print();
			}
		},"线程B").start();
	}
}
