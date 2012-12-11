package com.baidu.memcachedha;

/**
 * Instance this class to package your command parameter
 * @author xuchenCN
 *
 */
public class CommandParam {
	
	private String methodName;
	private Class<?>[] types;
	private Object[] args;

	public CommandParam(String methodName, Class<?>[] types, Object[] args) {
		super();
		this.methodName = methodName;
		this.types = types;
		this.args = args;
	}
	
	/**
	 * set your want to invoke method name
	 * @param methodName
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	/**
	 * set your parameters types
	 * @param types
	 */
	public void setTypes(Class<?>[] types) {
		this.types = types;
	}
	
	/**
	 * set your parameters
	 * @param args
	 */
	public void setArgs(Object[] args) {
		this.args = args;
	}

	public String getMethodName() {
		return methodName;
	}

	public Class<?>[] getTypes() {
		return types;
	}

	public Object[] getArgs() {
		return args;
	}

}
