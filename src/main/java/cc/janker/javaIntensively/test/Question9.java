package cc.janker.javaIntensively.test;

import java.util.HashSet;
import java.util.Set;

interface Animal2{}
class Mouse implements Animal2{
	int legs;
	public Mouse(int legs) {
		this.legs = legs;
	}
	@Override
	public String toString() {
		return "Mouse"+legs;
	}
}
public class Question9 {

	public static void main(String[] args) {
		Set set = new HashSet<>();
		set.add(new Mouse(0));
		set.add(new Mouse(0));
		set.add(new Integer(0));
		set.add(new Integer(0));
		System.out.println(set);
	}

}
