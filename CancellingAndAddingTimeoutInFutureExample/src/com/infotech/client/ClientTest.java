package com.infotech.client;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.infotech.service.RemoteService;

public class ClientTest {
	
	public static void main(String[] args) {

		ExecutorService executorService = null;
		try {
			executorService = Executors.newSingleThreadExecutor();
			long sTime = System.currentTimeMillis();
			Future<String> future = executorService.submit(new MyTask(new RemoteService()));
			
			while (!future.isDone()) {
				long totalTime = System.currentTimeMillis()-sTime;
				if(totalTime>20){
					System.out.println("Task is taking long time to execute so cancelling it..");
					future.cancel(true);
				}
			}
			
			try {
				String result = future.get(2, TimeUnit.SECONDS);
				System.out.println(result);
			} catch (InterruptedException | ExecutionException | TimeoutException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(executorService != null){
				executorService.shutdown();
			}
		}
	}

}
