import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // 创建一个 LinkedHashMap
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f,true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);

        // 在访问任何元素之前显示地图
        System.out.println("\nDisplay before any access");
        System.out.println(linkedHashMap);

        // 访问 Lewis 以获取他的年龄
        System.out.println("\nThe age for Lewis is " + linkedHashMap.get("Lewis"));

        // 在访问一个元素之后显示地图
        System.out.println("After an element is accessed the entries in LinkedHashMap are\n");
        System.out.println(linkedHashMap);
    }
}
