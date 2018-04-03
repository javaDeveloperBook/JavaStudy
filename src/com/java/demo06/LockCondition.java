package com.java.demo06;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者实现方式02：Lock condition模式
 * 
 * Lock  lock = new ReentrantLock();
 * Condition pCondition = lock.newCondition();
 * Condition cCondition = lock.newCondition();
 * 
 * @author jack w
 *
 */
public class LockCondition {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition pCondition = lock.newCondition();
		Condition cCondition = lock.newCondition();
		Resource resource = new Resource(lock, pCondition, cCondition);
		
		ProviderTwo providerTwo = new ProviderTwo(resource);
		ConsumerTwo consumerTwo = new ConsumerTwo(resource);
		new Thread(providerTwo).start();
		new Thread(consumerTwo).start();
	}
}

class Resource {
	/**
	 * 暂存数据
	 */
	private String data;
	/**
	 * 判断是否可以生产和消费数据
	 */
	private boolean flag = true;
	/**
	 * 锁
	 */
	private Lock lock;
	/**
	 * 生产条件
	 */
	private Condition pCondition;
	/**
	 * 消费条件
	 */
	private Condition cCondition;

	public Resource(Lock lock, Condition pCondition, Condition cCondition) {
		this.lock = lock;
		this.pCondition = pCondition;
		this.cCondition = cCondition;
	}

	/**
	 * 生产数据
	 * 
	 * @param data
	 */
	public void add(String data) {
		lock.lock();
		try {
			if (flag) {
				this.data = data;
				this.flag = false;
				cCondition.signalAll();
			} else {
				pCondition.await();
				System.out.println("生产者等待");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	/**
	 * 消费者消费数据
	 */
	public void get() {
		lock.lock();
		try {
			if (!flag) {
				System.out.println(this.data);
				this.flag = true;
				pCondition.signalAll();
			} else {
				cCondition.await();
				System.out.println("消费者等待");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}

class ProviderTwo implements Runnable {

	private Resource resource;

	public ProviderTwo(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		int num = 0;
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.add("车票" + num++);
		}
	}

}

class ConsumerTwo implements Runnable {

	private Resource resource;

	public ConsumerTwo(Resource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			resource.get();
		}
	}

}