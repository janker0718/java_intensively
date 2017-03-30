package cc.janker.javaIntensively.io.netty;

import cc.janker.javaIntensively.io.decode.msgpack.MessagepackDecoder;
import cc.janker.javaIntensively.io.decode.msgpack.MessagepackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {
	private final String host;
	private final int port;
	private final int sendNumber;
	public EchoClient(String host,int port ,int sendNumber) {
		this.host = host;
		this.port = port;
		this.sendNumber = sendNumber;
	}
	public void run() {
		//配置这个clinet
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 3000).handler(new ChannelInitializer<SocketChannel>() {
				@Override
				protected void initChannel(SocketChannel ch) throws Exception {
					
					//ch.pipeline().addLast(new TimeClientHandler());
//					ByteBuf deBuf = Unpooled.copiedBuffer("$_".getBytes());
//					ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,deBuf));
//					ch.pipeline().addLast(new StringDecoder());
//					ch.pipeline().addLast(new EchoClientHandler());
					ch.pipeline().addLast("msgpack decoder",new MessagepackDecoder());
					ch.pipeline().addLast("msgpack decoder",new MessagepackEncoder());
					ch.pipeline().addLast(new EchoClientHandler(sendNumber));
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
//	private void connect(int port,String host) throws Exception {
//		EventLoopGroup group = new NioEventLoopGroup();
//		try {
//			Bootstrap b = new Bootstrap();
//			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(new ChannelInitializer<SocketChannel>() {
//				@Override
//				protected void initChannel(SocketChannel ch) throws Exception {
//					
//					//ch.pipeline().addLast(new TimeClientHandler());
//					ByteBuf deBuf = Unpooled.copiedBuffer("$_".getBytes());
//					ch.pipeline().addLast(new DelimiterBasedFrameDecoder(1024,deBuf));
//					ch.pipeline().addLast(new StringDecoder());
//					ch.pipeline().addLast(new EchoClientHandler(send));
//				}
//			});
//			//发起异步连接操作
//			ChannelFuture f = b.connect(host, port).sync();
//			//等待客户端链路关闭
//			f.channel().closeFuture().sync();
//			
//		} finally{
//			group.shutdownGracefully();
//		}
//	}
	public static void main(String[] args) throws Exception {
		int port = 8080;
		if (args != null && args.length > 0) {
			try {
				port = Integer.valueOf(args[0]);
			} catch (NumberFormatException e) {
			}
		}
		new EchoClient("127.0.0.1", port, 1000).run();
	}
}
