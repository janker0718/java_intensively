package cc.janker.javaIntensively.test;

public class JieChengTest {
	public static void main(String[] args) {
		jieCheng();
	}

	private static void jieCheng() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(i+"x"+j+"="+i*j+" ");
			}
			System.out.println();
		}
	}
}
