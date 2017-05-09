package cc.janker.javaIntensively.test;

enum Animal{T,L,W,D}
public class Question3 {

	public static void main(String[] args) {
		Animal val = Animal.values()[1];
		switch (val) {
		case D:
			System.out.println("D");
			break;
		case T:
			System.out.println("T");
		case W:
			System.out.println("W");
		case L:
			System.out.println("L");
		default:
			break;
		}
	}

}
