import java.util.LinkedList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorTest {
    public static void main(String[] args) {
        // 创建一个包含100,000个Integer对象的LinkedList
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }

        // 创建一个计时器
        long startTimeGet = System.currentTimeMillis();

        // 使用get()方法遍历LinkedList
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTimeGet = System.currentTimeMillis();
        System.out.println("Time consumed by get(): " + (endTimeGet - startTimeGet) + " ms");

        // 创建一个计时器
        long startTimeIterator = System.currentTimeMillis();

        // 使用迭代器遍历LinkedList
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTimeIterator = System.currentTimeMillis();
        System.out.println("Time consumed by iterator(): " + (endTimeIterator - startTimeGet) + " ms");
    }
}