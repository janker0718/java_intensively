package cc.janker.javaIntensively.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeExample {
	public static void main(String[] args) throws IOException {
		final PipedOutputStream outputStream = new PipedOutputStream();
		final PipedInputStream inputStream = new PipedInputStream(outputStream);
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
