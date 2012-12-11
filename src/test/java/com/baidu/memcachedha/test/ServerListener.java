package com.baidu.memcachedha.test;

import com.baidu.memcachedha.MemcachedClientKeeper;
import com.baidu.memcachedha.listener.ServerStatListener;

public class ServerListener implements ServerStatListener{

	public void serverDown(MemcachedClientKeeper<?> keeper, int activeServerNumber) {
		// TODO Auto-generated method stub
		
	}

	public void serverUp(MemcachedClientKeeper<?> keeper, int activeServerNumber) {
		// TODO Auto-generated method stub
		
	}
	
	
}
