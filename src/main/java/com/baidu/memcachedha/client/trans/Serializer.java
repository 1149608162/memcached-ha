package com.baidu.memcachedha.client.trans;

import com.baidu.memcachedha.client.CommandData;

public interface Serializer {

	public CommandData encode(Object o);

	public Object decode(CommandData commandData);
}
