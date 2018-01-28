package com.infotech.client;

import java.util.concurrent.Callable;

import com.infotech.service.RemoteService;

public class MyTask implements Callable<String>{

	private RemoteService remoteService;
	
	public MyTask(RemoteService remoteService) {
		this.remoteService = remoteService;
	}

	public String call() throws Exception {
		return remoteService.remoteService();
	}

}
