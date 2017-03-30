package cc.janker.javaIntensively.io.netty;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
@Sharable
public class EchoServerHandler extends ChannelHandlerAdapter{
	int counter = 0;
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		String body = (String) msg;
//		System.out.println("the is :"+ ++counter + "times receive client: ["+body+"}" );
//		body += "$_";
//		ByteBuf echo = Unpooled.copiedBuffer(body.getBytes());
//		ctx.writeAndFlush(echo);
		System.out.println("receive client: ["+msg+"]" );
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();	//发生异常 关闭链路
	}
}
