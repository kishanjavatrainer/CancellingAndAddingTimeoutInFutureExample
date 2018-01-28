package com.infotech.service;

public class RemoteService {

	public String remoteService(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Remote Service";
	}
}
