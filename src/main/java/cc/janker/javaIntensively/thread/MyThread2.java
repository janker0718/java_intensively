package cc.janker.javaIntensively.thread;

public class MyThread2 extends Thread {

	private String showChar;
	private int showNumPosition;



	public MyThread2(String showChar, int showNumPosition) {
		super();
		this.showChar = showChar;
		this.showNumPosition = showNumPosition;
	}

	@Override
	public void run() {
		System.out.println(showChar);
	}
}
