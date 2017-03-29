package cc.janker.javaIntensively.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


public class TimeClientHandle implements Runnable{

	private String host;
	private int port;
	private Selector selector;
	private SocketChannel socketChannel;
	private volatile boolean stop;
	
	public TimeClientHandle(String host,int port) {
		// TODO Auto-generated constructor stub
		this.host = host ==null?"127.0.0.1":host;
		this.port = port;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}
	@Override
	public void run() {
		try {
			doConnect();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		while (!stop) {
			try {
				selector.select(1000);
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> it = selectionKeys.iterator();
				SelectionKey key = null;
				while (it.hasNext()) {
					key =  it.next();
					it.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						// TODO: handle exception
						if (key!=null) {
							key.cancel();
							if (key.channel() != null) {
								key.channel().close();
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.exit(1);
			}
		}
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
		// TODO Auto-generated method stub
		if (key.isValid()) {
			//判断是否连接成功
			SocketChannel sc = (SocketChannel) key.channel();
			if (key.isConnectable()) {
				if (sc.finishConnect()) {
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}else{
					System.exit(1);
				}
			}
			if (key.isReadable()) {
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if (readBytes > 0) {
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes,"UTF-8");
					System.out.println("Now is:"+body);
					this.stop = true;
				}else if (readBytes < 0 ) {
					
					key.cancel();
					sc.close();
				}else
					;
			}
		}
		
	}
	private void doWrite(SocketChannel sc) throws IOException {
		// TODO Auto-generated method stub
		byte[] req = "QUERY TIME ORDER".getBytes();
		ByteBuffer wrBuffer = ByteBuffer.allocate(req.length);
		wrBuffer.put(req);
		wrBuffer.flip();
		sc.write(wrBuffer);
		if (!wrBuffer.hasRemaining()) {
			System.out.println("Send order 2 server succeeed.");
		}
		
	}
	private void doConnect() throws IOException {
		//如果直接连接成功 则注册到多路复用器 发送请求消息  读应答
		if (socketChannel.connect(new InetSocketAddress(host, port))) {
			socketChannel.register(selector, SelectionKey.OP_READ);
			doWrite(socketChannel);
		}else
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
	}
	

}
