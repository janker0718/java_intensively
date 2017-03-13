package cc.janker.javaIntensively;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        String[] str = {"1","2"};
//        String[] str2 = Arrays.copyOf(str, str.length);
//        for (String string : str2) {
//			System.out.println(string);
//		}
    	System.out.println((int)(13/.75f));
    	System.out.println(Math.max((int) (13/.75f) + 1, 16));
    	Map<String, Object> map = new HashMap<>();
    	System.out.println(map.put("111", new Object()));
    	System.out.println(map.remove("111"));
    	System.out.println(1 << 30);
    }
}
