package cc.janker.javaIntensively.test;
class ThreeException extends Exception{}
public class Question7 {
	static int count = 0;
	public static void main(String[] args) {
		while (true) {
			try {
				if (count++ == 0)
					throw new ThreeException();
					System.out.println("No exception");
			} catch (ThreeException e) {
				// TODO: handle exception
				System.out.println("ThreeException");
			}finally {
				System.err.println( "in finall");
				if (count ==2) {
					break;
				}
			}
		}
	}
}
