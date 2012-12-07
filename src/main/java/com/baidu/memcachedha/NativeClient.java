package com.baidu.memcachedha;

import java.io.IOException;

import com.baidu.memcachedha.client.Client;
import com.baidu.memcachedha.client.ClientFactory;
import com.baidu.memcachedha.client.Command;
import com.baidu.memcachedha.client.CommandPrototype;
import com.baidu.memcachedha.protocol.CommandEnum;
import com.baidu.memcachedha.protocol.binary.BinaryCommandFactory;

public final class NativeClient {

	private Client client;
	private static ClientFactory clientFactory = new ClientFactory();

	public NativeClient(String ip, int port) throws IOException {

		client = clientFactory.getDefaultClient(ip, 11211);
	}

	public Object add(String key, int expiry, Object value) {

		CommandPrototype cp = new CommandPrototype(CommandEnum.Add.toString(), key, expiry, value);
		Command command = BinaryCommandFactory.factoryCommand(CommandEnum.Add, cp);
		return client.sendCommand(command);
	}
	
	public Object get(String key) {

		CommandPrototype cp = new CommandPrototype(CommandEnum.Get.toString(), key, 0, null);
		Command command = BinaryCommandFactory.factoryCommand(CommandEnum.Get, cp);
		return client.sendCommand(command);
	}
}
