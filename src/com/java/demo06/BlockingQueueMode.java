package com.java.demo06;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 生产者消费者实现03 : 阻塞队列模型
 * 
 * @author jack w
 *
 */
public class BlockingQueueMode {
	public static void main(String[] args) {
		BlockingQueueResource resource = new BlockingQueueResource();
		ProviderThree providerThree = new ProviderThree(resource);
		ConsumerThree consumerThree = new ConsumerThree(resource);

		new Thread(providerThree).start();
		new Thread(consumerThree).start();
	}
}

class BlockingQueueResource {
	/**
	 * 暂存数据的阻塞队列
	 */
	private BlockingQueue<String> queue = new LinkedBlockingQueue<String>(5);

	/**
	 * 生产数据，放入阻塞队列中
	 * 
	 * @param data
	 */
	public void add(String data) {
		try {
			queue.add(data);
			System.out.println( "当前产品个数"+ queue.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String get() {
		try {
			System.out.println( "当前产品个数"+ (queue.size()-1));
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
	}

}

class ProviderThree implements Runnable {
	
	private BlockingQueueResource resource;

	public ProviderThree(BlockingQueueResource resource) {
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

class ConsumerThree implements Runnable {
	
	private BlockingQueueResource resource;

	public ConsumerThree(BlockingQueueResource resource) {
		this.resource = resource;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(120);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(resource.get());
		}
	}

}