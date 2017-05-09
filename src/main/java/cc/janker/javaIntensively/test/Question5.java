package cc.janker.javaIntensively.test;

class Cat{
	private int legs;

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		this.legs = legs;
	}

	@Override
	public String toString() {
		return ""+this.legs;
	}
	
}
public class Question5 {
	public void changeCatLeg(final Cat cat){
		cat.setLegs(5);
	}
	public static void main(String[] args) {
		Question5 test = new Question5();
		Cat cat = new Cat();
		cat.setLegs(3);
		test.changeCatLeg(cat);
		System.out.println(cat);
	}
}
