package com.baidu.memcachedha.test;

import net.rubyeye.xmemcached.XMemcachedClient;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.baidu.memcachedha.CommandParam;
import com.baidu.memcachedha.MemcachedClientDispatch;
import com.baidu.memcachedha.MemcachedClientKeeper;
import com.baidu.memcachedha.ReloadLevel;

public class TestSpring {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		 String[] files = new String[] { "classpath*:config/spring/spring-test.xml"};
 
		ApplicationContext ctx = new ClassPathXmlApplicationContext(files);
		
		MemcachedClientDispatch dispatch = (MemcachedClientDispatch)ctx.getBean("clientDispatch");
		
		String ip1 = "127.0.0.1";
		int port1 = 11211;
		String ip2 = "127.0.0.1";
		int port2 = 11233;
		XMemcachedClient client1 = new XMemcachedClient(ip1, port1);
		XMemcachedClient client2 = new XMemcachedClient(ip1, port2);
		MemcachedClientKeeper<XMemcachedClient> k1 = new MemcachedClientKeeper<XMemcachedClient>(client1, ip1, port1);
		MemcachedClientKeeper<XMemcachedClient> k2 = new MemcachedClientKeeper<XMemcachedClient>(client2, ip1, port2);
		
		dispatch.addKeeper(k1);
		dispatch.addKeeper(k2);
		
		String key = "testKey";
		
		CommandParam getParam = new CommandParam("get", new Class[] { String.class }, new Object[] { key });
		CommandParam addParam = new CommandParam("add", new Class[] { String.class, int.class, Object.class },
				new Object[] { key, 0, "testValue" });

		dispatch.command(key, addParam, true, ReloadLevel.UNRELOAD, 0);
		
		System.out.println(dispatch.command(key, getParam, false, ReloadLevel.ONLYMISS, 0));
	}

}
