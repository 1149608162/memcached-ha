package com.baidu.memcachedha.test;

import java.util.Set;
import java.util.TreeSet;

import net.rubyeye.xmemcached.XMemcachedClient;

import com.baidu.memcachedha.CommandParam;
import com.baidu.memcachedha.MemcachedClientDispatch;
import com.baidu.memcachedha.MemcachedClientKeeper;
import com.baidu.memcachedha.ReloadLevel;

public class TestMemcachedHA {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String ip1 = "10.44.73.14";

		XMemcachedClient client1 = new XMemcachedClient(ip1, 8111);
		XMemcachedClient client2 = new XMemcachedClient(ip1, 8122);
		MemcachedClientKeeper<XMemcachedClient> k1 = new MemcachedClientKeeper<XMemcachedClient>(client1, ip1, 8111);
		MemcachedClientKeeper<XMemcachedClient> k2 = new MemcachedClientKeeper<XMemcachedClient>(client2, ip1, 8122);

		MemcachedClientDispatch dispatch = new MemcachedClientDispatch();
		dispatch.addKeeper(k1);
		dispatch.addKeeper(k2);
		Set<String> syncMethods = new TreeSet<String>();
		syncMethods.add("add");
		syncMethods.add("set");
		dispatch.setSyncMethods(syncMethods);

		String key = "testKey";

		long start = System.currentTimeMillis();
		for (int i = 0; i <= 1000; i++) {
			// Thread.sleep(300);
			key = key + i;

			CommandParam getParam = new CommandParam("get", new Class[] { String.class }, new Object[] { key });
			CommandParam addParam = new CommandParam("add", new Class[] { String.class, int.class, Object.class },
					new Object[] { key, 0, "testValue" + i });

			dispatch.command(key, addParam, true, ReloadLevel.UNRELOAD, 0);

			// System.out.println(dispatch.command(key,getParam,
			// false,ReloadLevel.CHECKALL,0));
			key = "testKey";
		}

		System.out.println(System.currentTimeMillis() - start);

	}

}
