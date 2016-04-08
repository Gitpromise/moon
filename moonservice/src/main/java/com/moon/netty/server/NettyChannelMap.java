package com.moon.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.SocketChannel;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NettyChannelMap {
	private static Map<String, SocketChannel> map = new ConcurrentHashMap<String, SocketChannel>();

	public static void add(String clientId, SocketChannel socketChannel) {
		map.put(clientId, socketChannel);
	}

	public static Channel get(String clientId) {
		return map.get(clientId);
	}


	public static Set<String> getKeyByValue(SocketChannel socketChannel) {
		Set<String> keys = new HashSet<String>();
		for (Map.Entry<String,SocketChannel> entry : map.entrySet()) {
			if (entry.getValue() == socketChannel) {
				String key = (String) entry.getKey();
				keys.add(key);
			}
		}
		return keys;
	}

	public static void removeByKey(String key) {
		if (!StringUtils.isEmpty(key)) {
			map.remove(key);
		}
	}

	public static Collection<SocketChannel> values() {
		return map.values();
	}

	public static Set<String> getKeys() {
		return map.keySet();
	}

}
