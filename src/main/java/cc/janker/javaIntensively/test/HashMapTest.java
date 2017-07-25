package cc.janker.javaIntensively.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhiyongliu3 on 2017/7/25.
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,List<String>>  map = HashMapTest.newInstance();
    }

    /**
     * 静态工厂方法
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K,V> HashMap<K,V> newInstance(){
        return new HashMap<K,V>();
    }
}
