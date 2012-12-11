package com.baidu.memcachedha;

/**
 * which level you need
 * 
 * @author xuchenCN
 * 
 */
public interface ReloadLevel {
	
	/**
	 * Unreload
	 */
	public static final int UNRELOAD = 0x00;
	
	/**
	 * reload only miss
	 */
	public static final int ONLYMISS = 0x01;

	/**
	 * reload every command
	 */
	public static final int CHECKALL = 0x02;
}
