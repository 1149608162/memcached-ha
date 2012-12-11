package com.baidu.memcachedha;

/**
 * server status
 * 
 * @author xuchenCN
 * 
 */
public interface Stat {
	/**
	 * server is online
	 */
	public static final int STAT_ONLINE = 0x00;

	/**
	 * server is outline
	 */
	public static final int STAT_OUTLINE = 0x01;
}
