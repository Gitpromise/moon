package com.moon.netty.client;

import org.springframework.stereotype.Component;

/**
 * Created by maguoqiang on 2016/3/17.
 */
@Component
public class BootClient {

    public static void main(String[] args) throws InterruptedException {

        new NettyClient(9999,"localhost");
    }
}
