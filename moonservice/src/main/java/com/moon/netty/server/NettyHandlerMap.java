package com.moon.netty.server;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class NettyHandlerMap {

    private static Map<String, ChannelHandlerContext> map = new ConcurrentHashMap<String, ChannelHandlerContext>();

    public static void add(String clientId, ChannelHandlerContext ct) {
        map.put(clientId, ct);
    }

    public static ChannelHandlerContext get(String clientId) {
        return map.get(clientId);
    }


    public static Set<String> getKeyByValue(ChannelHandlerContext ct) {
        Set<String> keys = new HashSet<String>();
        for (Map.Entry<String,ChannelHandlerContext> entry : map.entrySet()) {
            if (entry.getValue() == ct) {
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

    public static Collection<ChannelHandlerContext> values() {
        return map.values();
    }

    public static Set<String> getKeys() {
        return map.keySet();
    }
}
