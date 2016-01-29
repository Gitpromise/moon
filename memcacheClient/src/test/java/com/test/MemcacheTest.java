package com.test;
//
//import com.alibaba.fastjson.JSON;
//import com.danga.MemCached.MemCachedClient;
//import com.danga.MemCached.SockIOPool;
//
//import java.io.*;
//import java.util.Date;

/**
 * Created by fanshuai on 15/5/12.
 */
public class MemcacheTest {
//
//    private static MemCachedClient c = new MemCachedClient();
//    public static void main(String[] args){
//        /* 定义IP地址和端口 */
//        String[] servers = { "192.168.120.130:11111" };
//        /* 设置缓存大小 */
//        Integer[] weights = { 2 };
//        /* 拿到一个连接池的实例 */
//        SockIOPool pool = SockIOPool.getInstance();
//        /* 注入服务器组信息 */
//        pool.setServers(servers);
//        pool.setWeights(weights);
//        /* 配置缓冲池的一些基础信息 */
//        pool.setInitConn(5);
//        pool.setMinConn(5);
//        pool.setMaxConn(250);
//        pool.setMaxIdle(1000 * 60 * 60 * 6);
//        /* 设置线程休眠时间 */
//        pool.setMaintSleep(30);
//        /* 设置关于TCP连接 */
//        pool.setNagle(false);// 禁用nagle算法
//        pool.setSocketConnectTO(0);
//        pool.setSocketTO(3000);// 3秒超时
//        /* 初始化 */
//        pool.initialize();
//        System.out.println(new Date(1));
//        boolean b = c.set("abcdffg", new AAA("ccccdd"),new Date(1));
//        //c.set()
//        AAA a = new AAA("ccccdd");
//        try {
//            //Thread.currentThread().sleep(5000l);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//        try {
//            aa(a);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void aa(Object obj) throws Exception{
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
//        objectOutputStream.writeObject(obj);
//        byte[] bytes = byteArrayOutputStream.toByteArray();
//        c.set("bytes",bytes);
//        byte[] bbb = (byte[])c.get("bytes");
////        String serStr = byteArrayOutputStream.toString("ISO-8859-1");
////        serStr = java.net.URLEncoder.encode(serStr, "UTF-8");
//
//        objectOutputStream.close();
//        byteArrayOutputStream.close();
//
////        System.out.println(serStr);
//
////        String redStr = java.net.URLDecoder.decode(serStr, "UTF-8");
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bbb);
//        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
//        Object  newObj = objectInputStream.readObject();
//        objectInputStream.close();
//        byteArrayInputStream.close();
//        System.out.println(newObj);
//    }
//
//    public static class AAA implements Serializable{
//        public AAA(String a){
//            this.aa
//                     = a;
//        }
//        public String aa="cc";
//
//        @Override
//        public String toString() {
//            return "AAA{" +
//                    "aa='" + aa + '\'' +
//                    '}';
//        }
//    }
}
