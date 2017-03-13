package cc.janker.javaIntensively.collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		Set<String> h = new HashSet<>();
		h.add("1st");
		h.add("2nd");
	    h.add("2nd");            //重复元素，未被添加
	    System.out.println("开始:size="+h.size());
	    Iterator<String> iterator = h.iterator();
	    while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(string);
		}
	    h.remove("2nd");
	    System.out.println("移除后的元素：size = "+h.size());
	    System.out.println(h);
	}
}
