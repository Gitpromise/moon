package com.moon.netty.server;

import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mgq on 2016/3/8.
 */
@Component("bootServer")
public class BootServer {
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args){
        NettyServerBootstrap bootstrap=new NettyServerBootstrap(9999);//创建并启动服务端
        bootstrap.bind();
    }
}
