package com.moon.netty.thread.servertask;

import com.alibaba.fastjson.JSONObject;
import com.moon.netty.server.NettyHandlerMap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

import java.io.UnsupportedEncodingException;

public class Thread01 implements Runnable {

    @Override
    public void run() {
        ChannelHandlerContext ct= NettyHandlerMap.get("001");
        JSONObject obj01=new JSONObject();
        obj01.put("C_NAME", "测试");
        obj01.put("C_APPOINT_DATE", "2016-02-20 10:19:28");
        obj01.put("C_MOBILE", "18221811952");
        obj01.put("C_SEX", "1");
        obj01.put("card_type_name", "无卡预约");
        obj01.put("C_ORDER_NO", "Q201602190007");
        obj01.put("MEMBER_MOBILE", "18221811959");
        try {
            ct.writeAndFlush(getSendByteBuf(obj01.toString()));
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("thread01启动......");
    }
    private ByteBuf getSendByteBuf(String message)
            throws UnsupportedEncodingException {

        byte[] req = message.getBytes("UTF-8");
        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(req);

        return pingMessage;
    }
}
