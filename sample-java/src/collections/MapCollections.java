package collections;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sskim
 */
public class MapCollections {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        map.putIfAbsent("D", 4);

        map.computeIfAbsent("A", (key) -> 10);
        System.out.println("map = " + map);

        map.forEach((s, integer) -> System.out.println(s));

        map.replaceAll((s, integer) -> 111);
        System.out.println("map = " + map);

        int intValue = Integer.MAX_VALUE;
        long longValue = 2L;

        long result = intValue + longValue;
        System.out.println("result = " + result);
    }
}
