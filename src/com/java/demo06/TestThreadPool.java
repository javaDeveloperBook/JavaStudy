package com.java.demo06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 测试线程池
 * 1.ExecutorService executor = Executors.newSingleThreadExecutor();
 * 2.
 * @author jack w
 *
 */
public class TestThreadPool {
	public static void main(String[] args) {
		/**
		 * 第一种：直接 new ThreadPoolExecutor
		 */
		//ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(5));
		/**
		 * 第二种：单线程的线程池
		 */
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		/**
		 * 第三种：无数线程的线程池
		 */
		//ExecutorService executor = Executors.newCachedThreadPool();
		/**
		 * 第四种：创建固定大小的线程池
		 */
		ExecutorService executor = Executors.newFixedThreadPool(5);
		
		
		for (int i = 0; i < 15; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
//			System.out.println("线程池中的线程数目"+executor.getPoolSize());
//			System.out.println("队列中等待的任务数"+executor.getQueue().size());
//			System.out.println("已执行完的任务数"+executor.getCompletedTaskCount());
			System.out.println();
		}
		executor.shutdown();
	}

}

class MyTask implements Runnable {

	private int taskNum = 0;

	public MyTask(int taskNum) {
		this.taskNum = taskNum;
	}

	@Override
	public void run() {
		System.out.println("正在执行task" + taskNum);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task" + taskNum + "执行完毕");

	}

}
