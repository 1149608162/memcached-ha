package com.baidu.memcachedha.test;

import java.util.Map;

import com.baidu.memcachedha.CommandParam;
import com.baidu.memcachedha.MemcachedClientKeeper;
import com.baidu.memcachedha.listener.CommandListener;

public class RequestListener implements CommandListener{

	public void onCommandError(MemcachedClientKeeper<?> keeper, CommandParam param) {
		// TODO Auto-generated method stub
		
	}

	public void onCommandResponsed(MemcachedClientKeeper<?> keeper, CommandParam param, Object response) {
		// TODO Auto-generated method stub
		
	}

	public void onAllCommandResponsed(Map<MemcachedClientKeeper<?>, Object> responses, CommandParam param) {
		// TODO Auto-generated method stub
		
	}
	
}
