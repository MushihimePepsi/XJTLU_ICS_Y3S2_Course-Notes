import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        // 创建两个优先队列并添加元素
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();

        String[] elements1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String[] elements2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};

        for (String element : elements1) {
            queue1.add(element);
        }
        for (String element : elements2) {
            queue2.add(element);
        }

        // 获取并集
        PriorityQueue<String> union = new PriorityQueue<>(queue1);
        union.addAll(queue2);
        System.out.println("Union: " + union);

        // 获取差集
        queue1.removeAll(queue2);
        System.out.println("Difference (queue1): " + queue1);

        // 获取交集
        queue2.retainAll(queue1);
        System.out.println("Intersection (queue2): " + queue2);
    }
}