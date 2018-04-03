package com.java.demo06;

/**
 * 测试生产者和消费者模型 01：wait/notify模式
 * 
 * 1.解决同步（synchronized） 
 * 2.解决重复操作（wait()、notify()）
 * 
 * @author jack w
 *
 */
public class ProviderAndConsumer {
	public static void main(String[] args) {
		Data data = new Data();
		new Thread(new Provider(data)).start();
		new Thread(new Consumer(data)).start();
	}
}

/**
 * 保存生产数据
 */
class Data {
	private String ticket;
	/**
	 * flag = true : 可以生产，不可以消费 flag = false : 不可以生产，可以消费
	 */
	private boolean flag = true;

	/**
	 * 生产设置方法
	 * 
	 * @param ticket
	 */
	public synchronized void set(String ticket) {
		if (flag) {
			this.ticket = ticket;
			flag = false;
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 消费打印方法
	 */
	public synchronized void get() {
		if (!flag) {
			System.out.println(this.ticket);
			flag = true;
			notifyAll();
		} else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 生产者
 */
class Provider implements Runnable {
	private Data data;

	public Provider(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		int num = 0;
		while (true) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data.set("车票" + num++);
		}
	}

}

class Consumer implements Runnable {

	private Data data;

	public Consumer(Data data) {
		this.data = data;
	}

	@Override
	public void run() { 
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data.get();
		}
	}

}