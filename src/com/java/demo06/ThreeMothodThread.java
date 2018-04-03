package com.java.demo06;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 三种方式实现多线程
 * 
 * 1.直接继承Thread类
 * 
 * 2.实现Runnable接口
 * 
 * 3.实现Callable接口
 * 
 * 注意：一般不会写一个多线程任务类，最好是使用匿名内部类，重写run()方法
 * 
 * @author jack w
 *
 */
public class ThreeMothodThread {
	public static void main(String[] args) throws Exception{
		while (true) {
			//第一种执行多线程方式
			Thread.sleep(1000);
			new MyThread().start();
			
			//第二种执行多线程方式
			Thread.sleep(1000);
			new Thread(new MyRunnable()).start();
			
			//第三种执行多线程方式,并取得返回值打印输出
			Thread.sleep(1000);
			Callable<String> callable = new MyCallable();
			FutureTask<String> futureTask = new FutureTask<String>(callable);
			new Thread(futureTask).start();
			System.out.println(futureTask.get());
			
			
			//第四种执行多线程方式
			Thread.sleep(2000);
			ExecutorService executorService  = Executors.newSingleThreadExecutor();
			Future<String> future = executorService.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					return Thread.currentThread().getName()+" : "+ new Random().nextInt(100);
				}
				
			});
			System.out.println(future.get());
			
			
			Thread.sleep(2000);
			//第五种执行多个带返回值的多线程，并取得多个返回值打印输出
			//另一种实现返回多个值的方式：	以上的第四种方式实现多个Future[]
			ExecutorService executorService2 = Executors.newCachedThreadPool();
			CompletionService<String> completionService = new ExecutorCompletionService<>(executorService2);
			for(int i = 0 ; i < 5 ; i++){
				final int taskId = i ;
				completionService.submit(new Callable<String>(){
					@Override
					public String call() throws Exception {
						return Thread.currentThread().getName() +" : " + taskId;
					}
				});
			}
			
			for(int i = 0 ; i < 5 ; i++ ) {
				System.out.println(completionService.take().get());
			}
					
		}
	}
}

class MyThread extends Thread {
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" : 执行MyThread任务");
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" : 执行MyRunnable任务");
	}

}

class MyCallable implements Callable<String> {

	@Override
	public String call() throws Exception {
		return Thread.currentThread().getName()+ " : " + new Random().nextInt(100);
	}

}
