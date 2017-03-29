package cc.janker.javaIntensively.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import com.sun.prism.paint.Stop;

public class MultiplexerTimeServer implements Runnable{
	
	private Selector selector;
	private ServerSocketChannel serverSocketChannel;
	
	private volatile boolean stop;
	
	
	public MultiplexerTimeServer(int port) {
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			//设置非阻塞
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port),1024);
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("the time server is start im port："+ port);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}
	public void Stop(){
		this.stop = true;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key = it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						if (key!=null) {
							key.cancel();
							if (key.channel()!=null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Throwable e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		//多路复用器关闭后，所有注册在上面的channel和pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
		if (selector!=null) {
			try {
				selector.close();
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	private void handleInput(SelectionKey key) throws IOException {
		if (key.isValid()) {
			//处理新接入的请求消息
			if (key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
			if (key.isReadable()) {
				//read the data
				SocketChannel sc = (SocketChannel) key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					System.out.println("the time server receive order:"+body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)? new Date(System.currentTimeMillis()).toString():"BAD ORDER";
					doWrite(sc,currentTime);
				}else if (readBytes < 0) {
					key.cancel();
					sc.close();
				}else
					;
			}
		}
	}
	private void doWrite(SocketChannel sc, String response) throws IOException {
		// TODO Auto-generated method stub
		if (response!=null && response.trim().length()>0) {
			byte[] bytes = response.getBytes();
			ByteBuffer wrBuffer =ByteBuffer.allocate(bytes.length);
			wrBuffer.put(bytes);
			wrBuffer.flip();
			sc.write(wrBuffer);
		}
	}

}
