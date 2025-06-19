import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet1 = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

// 使用 NavigableSet 接口中的方法
        System.out.println("lower(5): " + treeSet1.lower(5));
        System.out.println("higher(5): " + treeSet1.higher(5));
        System.out.println("floor(5): " + treeSet1.floor(5));
        System.out.println("ceiling(5): " + treeSet1.ceiling(5));
        System.out.println("pollFirst(): " + treeSet1.pollFirst());
        System.out.println("pollLast(): " + treeSet1.pollLast());
        System.out.println("New tree set: " + treeSet1);

    }
}
