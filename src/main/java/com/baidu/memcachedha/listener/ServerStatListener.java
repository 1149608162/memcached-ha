package com.baidu.memcachedha.listener;

import com.baidu.memcachedha.MemcachedClientKeeper;

public interface ServerStatListener {
	
	public void serverDown(MemcachedClientKeeper<?> keeper ,int activeServerNumber);
	
	public void serverUp(MemcachedClientKeeper<?> keeper ,int activeServerNumber);
}
