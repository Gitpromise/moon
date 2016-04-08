package com.moon.netty.server;

import com.alibaba.fastjson.JSONObject;
import com.moon.base.utils.Constant;
import com.moon.netty.dto.BaseMsg;
import com.moon.netty.dto.Msg_Type;
import com.moon.netty.thread.servertask.Thread01;
import com.moon.netty.thread.servertask.Thread02;
import io.netty.channel.ChannelHandlerAdapter;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by mgq on 2016/3/1.
 */
public class NettyServerHandler extends ChannelHandlerAdapter {

    private static ExecutorService executorService = Executors.newCachedThreadPool();
    //服务端读取客户端请求
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            ByteBuf buf = (ByteBuf) msg;
            String rev = getMessage(buf);
            BaseMsg baseMsg=JSONObject.parseObject(rev, BaseMsg.class);
            /*
            * 1、assert <boolean表达式>
                如果<boolean表达式>为true，则程序继续执行。
                如果为false，则程序抛出AssertionError，并终止执行。

              2、assert <boolean表达式> : <错误信息表达式>
                如果<boolean表达式>为true，则程序继续执行。
                如果为false，则程序抛出java.lang.AssertionError，并输入<错误信息表达式>。
            *
            * */
            assert baseMsg != null:"客户端请求数据为空!";
            Msg_Type type=baseMsg.getMsgType();
            //System.out.println("客户端的请求:" + baseMsg);
            switch (type){
                case TYPE_TEST01:{
                    NettyHandlerMap.add("001",ctx);
                    Thread t01=new Thread(new Thread01());
                    t01.start();
                }
                break;
                case TYPE_TEST02:{
                    NettyHandlerMap.add("001",ctx);
                    Thread t02=new Thread(new Thread02());
                    t02.start();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //服务端发送请求道客户端（客户端需要启动才可以发送）
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        try {
            System.out.println("server 发送请求 start....");
//            Thread thread=new Thread(new Thread02());
//            thread.start();
        }catch (Exception e){

        }
    }
    /*
     * 从ByteBuf中获取信息 使用UTF-8编码返回
     */
    private String getMessage(ByteBuf buf) {

        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con,Constant.UTF8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ByteBuf getSendByteBuf(String message)
            throws UnsupportedEncodingException {

        byte[] req = message.getBytes("UTF-8");
        ByteBuf pingMessage = Unpooled.buffer();
        pingMessage.writeBytes(req);

        return pingMessage;
    }
}
