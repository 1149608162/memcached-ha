package com.baidu.memcachedha.listener;

import com.baidu.memcachedha.MemcachedClientKeeper;

/**
 * if you want listen server status event instance this class and set it to MemcachedClientDispatch
 * @author chenxu04
 *
 */
public interface ServerStatListener {
	
	public void serverDown(MemcachedClientKeeper<?> keeper ,int activeServerNumber);
	
	public void serverUp(MemcachedClientKeeper<?> keeper ,int activeServerNumber);
}
