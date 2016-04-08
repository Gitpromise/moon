package com.moon.netty.thread.servertask;

import com.moon.auth.entity.Depart;
import com.moon.auth.service.IDepartService;

import javax.annotation.Resource;

/**
 * Created by mgq on 2016/3/2.
 */
public class Thread02 implements Runnable {

    @Resource(name = "departServiceImpl")
    private IDepartService departService;
    @Override
    public void run() {
        System.out.println("thread02启动......");
        Depart depart=departService.getDepartById("1ad73acf05b511e5a09e02004c4f4f50");
        System.out.println(depart);
    }
}
