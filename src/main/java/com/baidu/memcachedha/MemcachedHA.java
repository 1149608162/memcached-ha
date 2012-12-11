package com.baidu.memcachedha;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * memcached-ha template class you can extends this class
 * reference this class program your memcached-ha facade
 * @author xuchenCN
 *
 * @param <T>
 */
public class MemcachedHA<T> {

	protected MemcachedClientDispatch dispatch = new MemcachedClientDispatch();

	public MemcachedClientDispatch getDispatch() {
		return dispatch;
	}

	public void setDispatch(MemcachedClientDispatch dispatch) {
		this.dispatch = dispatch;
	}
	
	/**
	 * this method can be instance a <tt>MemcachedClientKeeper</tt>
	 * @param server
	 * @param ip
	 * @param port
	 * @throws IOException
	 * 
	 * @see MemcachedClientKeeper
	 */
	public void addServer(T server, String ip, int port) throws IOException {
		MemcachedClientKeeper<T> k = new MemcachedClientKeeper<T>(server, ip, port);
		dispatch.addKeeper(k);
	}
	
	/**
	 * execute the memcached client method of 'set' and needSync param is true , unreload 
	 * @param key
	 * @param expiry
	 * @param value
	 * @return 
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object set(String key, int expiry, Object value) throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("set", new Class[] { String.class, Integer.class, String.class }, new Object[] {
				key, expiry, value });
		return dispatch.command(key, cp);
	}
	
	/**
	 * execute the memcached client method of 'set'
	 * @param key
	 * @param expiry
	 * @param value
	 * @param needSync when response is null and you need invoke method at other memcached server ,set is 'true'
	 * @return 
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object set(String key, int expiry, Object value, boolean needSync) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("set", new Class[] { String.class, Integer.class, String.class }, new Object[] {
				key, expiry, value });
		return dispatch.command(key, cp, needSync);
	}
	
	/**
	 * execute the memcached client method of 'add' and needSync param is true , unreload 
	 * @param key
	 * @param expiry
	 * @param value
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object add(String key, int expiry, Object value) throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("add", new Class[] { String.class, Integer.class, String.class }, new Object[] {
				key, expiry, value });
		return dispatch.command(key, cp);
	}

	/**
	 * execute the memcached client method of 'set'
	 * @param key
	 * @param expiry
	 * @param value
	 * @param needSync when response is null and you need invoke method at other memcached server ,set is 'true'
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object add(String key, int expiry, Object value, boolean needSync) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("add", new Class[] { String.class, Integer.class, String.class }, new Object[] {
				key, expiry, value });
		return dispatch.command(key, cp, needSync);
	}
	
	/**
	 * execute the memcached client method of 'get' and unreload
	 * @param key
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object get(String key) throws SecurityException, IllegalArgumentException, NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("get", new Class[] { String.class }, new Object[] { key, });
		return dispatch.command(key, cp);
	}
	
	/**
	 * execute the memcached client method of 'get'
	 * @param key
	 * @param reload if you need this return value synchronous to other memcached server set it > 0  use <tt>ReloadLevel</tt>
	 * @param reloadExpiry when reload what expiry you want
	 * @return
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public Object get(String key, final int reload, final int reloadExpiry) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		CommandParam cp = new CommandParam("get", new Class[] { String.class }, new Object[] { key, });
		return dispatch.command(key, cp,false,reload,reloadExpiry);
	}
}
