package cc.janker.javaIntensively.io.netty;

import cc.janker.javaIntensively.io.decode.UserInfo;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class EchoClientHandler extends ChannelHandlerAdapter {
	//private int counter;
	
	//static final String ECHO_REQ = "Hi, Lilingfeng , Welcome to Netty.$_";
	
	private final int sendNumber;
	
	public EchoClientHandler(int sendNumber) {
		// TODO Auto-generated constructor stub
		this.sendNumber = sendNumber;
	}
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
//		for (int i = 0; i < 100; i++) {
//			ctx.writeAndFlush(Unpooled.copiedBuffer(ECHO_REQ.getBytes()));
//		}
		UserInfo[] infos = UserInfo();
		for (UserInfo userInfo : infos) {
			ctx.write(userInfo);
		}
		ctx.flush();
	}
	private UserInfo[] UserInfo() {
		UserInfo[] userInfos = new UserInfo[sendNumber];
		UserInfo userInfo = null;
		for (int i = 0; i < sendNumber; i++) {
			userInfo = new UserInfo();
			userInfo.setAge(i);
			userInfo.setName("ABCDEFG-->"+i);
			userInfos[i] = userInfo;
		}
		return userInfos;
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		System.out.println("this is "+ ++counter +"times recieve server:["+msg +"]");
		System.out.println("client receive the msgpak message:"+msg);
		ctx.write(msg);
	}
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		
		ctx.flush();
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
}
