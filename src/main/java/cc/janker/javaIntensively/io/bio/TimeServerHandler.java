package cc.janker.javaIntensively.io.bio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {

	private Socket socket;
	public TimeServerHandler(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(),true);
			String cuuentTime = null;
			String body = null;
			while (true) {
				body = in.readLine();
				if (body == null) {
					break;
				}
				System.out.println("the time server reveive order:"+body);
				cuuentTime = "QUERY TIME ORDER".equalsIgnoreCase(body)?new Date(System.currentTimeMillis()).toString():"BAD ORDER";
				out.println(cuuentTime);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			if (in!=null) {
				try {
					in.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
			if (out!=null) {
				out.close();
				out = null;
			}
			if (this.socket !=null) {
				try {
					this.socket.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				this.socket = null;
			}
		}
	}

}
