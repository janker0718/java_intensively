package cc.janker.javaIntensively.jvm;

import java.util.ArrayList;
import java.util.List;
/***
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * @author zhiyongliu3
 *
 */
public class OOMExample {
	static class OOMObject{}
	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
