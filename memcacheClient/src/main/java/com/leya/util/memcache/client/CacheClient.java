package com.leya.util.memcache.client;

import com.ly.sdk.env.EnvProperties;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

import java.io.IOException;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanshuai on 15/4/27.
 */
public class CacheClient {
    private static MemcachedClient memcachedClient;
    
    private  static void initMemcachedConnect() throws Exception {
        //192.168.120.130:11111,192.168.2.2:2222
        if(memcachedClient==null){
            synchronized (CacheClient.class){
                if(memcachedClient==null){
                    String hostConfig = EnvProperties.get("memcache.address");
                    if(hostConfig==null){
                        throw new RuntimeException("not found \"memcache.address\" config with evn.properties");
                    }
                    List<InetSocketAddress> netAddressList = new ArrayList<InetSocketAddress>();
                    hostConfig = hostConfig.trim();
                    String [] hosts = hostConfig.split(",");
                    for (String host : hosts){
                        String[] ip_port =  host.split(":");
                        String ip = ip_port[0];
                        String port = ip_port[1];
                        InetSocketAddress netAddress = new InetSocketAddress(ip,Integer.decode(port));
                        netAddressList.add(netAddress);
                    }
                    try {
                        memcachedClient = new MemcachedClient((netAddressList.toArray(new InetSocketAddress[0])));
                    } catch (IOException e) {
                        throw e;
                    }
                }
            }
        }
    }

    public static OperationFuture<Boolean> add(String key,Object data,int exp) throws Exception {
        try {
            if(memcachedClient==null){
                initMemcachedConnect();
            }
            return memcachedClient.add(key,exp,data);
        }catch (Exception e){
            throw e;
        }

    }

    public static OperationFuture<Boolean> put(String key,Object data,int exp) throws Exception {
        try {
            if(memcachedClient==null){
                initMemcachedConnect();
            }
            return memcachedClient.set(key,exp,data);
        }catch (Exception e){
            throw e;
        }

    }


    public static Object get(String key) throws Exception {
        try {
            if(memcachedClient==null){
                initMemcachedConnect();
            }
            return memcachedClient.get(key);
        }catch (Exception e){
            throw e;
        }
    }

    public static void remove(String key)throws Exception {
        try {
            if(memcachedClient==null){
                initMemcachedConnect();
            }
            memcachedClient.delete(key);
        }catch (Exception e){
            throw e;
        }
    }


    public static void main(String [] args){
//        try {
//            Member m = new Member();
//            m.setAccount("asdf");
//            CacheClient.put("nameaa", m,30);
//            System.out.println(CacheClient.get("nameaa"));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
    public static class A implements Serializable{
        private  String name="cc";
        public A(String n){
            this.name = n;
        }

        @Override
        public String toString() {
            return "A{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
