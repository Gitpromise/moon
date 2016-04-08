package com.moon.netty.client;

import com.alibaba.fastjson.JSONObject;
import com.moon.base.utils.Constant;
import com.moon.netty.dto.BaseMsg;
import com.moon.netty.dto.Msg_Type;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
/**
 * Created by mgq on 2016/3/1.
 */
public class NettyClientHandler extends ChannelHandlerAdapter {
    private  ByteBuf firstMessage;

    //客户端发送请求道服务端（服务端要启动）
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client 发送请求start....");
        firstMessage=Unpooled.buffer();
        BaseMsg baseMsg=new BaseMsg();
        baseMsg.setMsgType(Msg_Type.TYPE_TEST02);
        String js=JSONObject.toJSONString(baseMsg);
        byte[] data1 =js.getBytes();
        firstMessage.writeBytes(data1);
        ctx.writeAndFlush(firstMessage);
    }
    //客户端接收服务端请求
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        String rev = getMessage(buf);
        System.out.println("客户端收到服务器数据:" + rev);
    }
    private String getMessage(ByteBuf buf) {
        byte[] con = new byte[buf.readableBytes()];
        buf.readBytes(con);
        try {
            return new String(con, Constant.UTF8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
