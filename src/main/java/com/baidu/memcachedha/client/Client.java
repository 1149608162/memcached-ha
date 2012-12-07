package com.baidu.memcachedha.client;


public interface Client {
	
	public Object sendCommand(final Command command);
}
