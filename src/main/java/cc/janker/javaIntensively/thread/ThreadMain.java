package cc.janker.javaIntensively.thread;

public class ThreadMain {
	public static void main(String[] args) throws InterruptedException {
//		Object lock = new Object();
//
//		MyThread a = new MyThread(lock, "A", 1);
//		MyThread b = new MyThread(lock, "B", 2);
//		MyThread c = new MyThread(lock, "C", 0);
//
//		a.start();
//		b.start();
//		c.start();
		MyThread2 a = new MyThread2("A", 0);
		MyThread2 b = new MyThread2("B", 1);
		MyThread2 c = new MyThread2("C", 2);
		a.start();
		a.join();
		b.start();
		b.join();
		c.start();
		c.join();
	}
}
