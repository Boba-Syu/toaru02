package com.hunau.netty.main;

import com.hunau.netty.config.BroadcastConfig;
import com.hunau.netty.handler.BroadcastSocketChannelHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MI on 2019/3/2.
 */
public class BroadcastMain {
    private static final Logger log = LoggerFactory.getLogger(BroadcastMain.class);

    public static void main(String[] args) {
        broadcastMain();
    }

    public static void broadcastMain() {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.childHandler(new BroadcastSocketChannelHandler());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");//设置日期格式
            String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            //System.out.println(date + "  服务端开启等待客户端连接...");
            log.info("NettyService对象host: " + BroadcastConfig.WEB_SOCKET_URL);
            log.info("服务端开启等待客户端连接...");
            Channel ch = b.bind(BroadcastConfig.port).sync().channel();
            ch.closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //优雅的退出程序
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}
