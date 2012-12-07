package com.baidu.memcachedha.protocol.binary;

import com.baidu.memcachedha.client.BinaryCommand;
import com.baidu.memcachedha.client.CommandPrototype;
import com.baidu.memcachedha.protocol.CommandEnum;

public class BinaryCommandFactory {

	public static BinaryCommand factoryCommand(CommandEnum commandEnum, CommandPrototype prototype) {
		return buildCommand(commandEnum, prototype);
	}

	private static BinaryCommand buildCommand(CommandEnum commandEnum, CommandPrototype prototype) {
		BinaryCommand command = new BinaryCommand();

		command.setBuffer(new BinaryProtocolParser().parserBuffer(commandEnum, prototype));

		return command;
	}

}
