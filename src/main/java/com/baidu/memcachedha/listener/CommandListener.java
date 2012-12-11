package com.baidu.memcachedha.listener;

import java.util.Map;

import com.baidu.memcachedha.CommandParam;
import com.baidu.memcachedha.MemcachedClientKeeper;

/**
 * if you want listen command event instance this class and set it to MemcachedClientDispatch
 * @author xuchenCN
 *
 */
public interface CommandListener {

	void onCommandError(final MemcachedClientKeeper<?> keeper,final CommandParam param);

	void onCommandResponsed(final MemcachedClientKeeper<?> keeper, final CommandParam param, Object response);

	void onAllCommandResponsed(final Map<MemcachedClientKeeper<?>, Object> responses, final CommandParam param);
}
