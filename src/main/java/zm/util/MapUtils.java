package zm.util;

import com.baomidou.mybatisplus.core.incrementer.IKeyGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUtils {
    public static void main(String[] args) {
        mapForeach1();
        mapForeach2();
        mapForeach3();

    }

    /**
     * 获取map的每个节点entry的set集合，（键值对）
     */
    public static void mapForeach1() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "zm");
        map.put("2", "ls");
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

    /**
     * 获取关于key的set集合  （键获取值）
     */
    public static void mapForeach2() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "zm1");
        map.put("2", "ls1");
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string + map.get(string));
        }
    }

    /**
     * 通过foreach的lambda表达式
     */
    public static void mapForeach3() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("1", "zm11");
        map.put("2", "ls11");
        map.forEach((key, value) -> {
            System.out.println(key + value);
        });
    }
}