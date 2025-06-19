import java.util.ArrayList;

public class MaxElementFinder {
    public static void main(String[] args) {
        // 创建一个包含Integer对象的ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(30);
        list.add(15);

        // 调用max方法找出最大元素
        Integer maxElement = max(list);

        // 打印最大元素
        System.out.println("The maximum element is: " + maxElement);
    }

    public static <E extends Comparable<E>> E max(ArrayList<E> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List must not be null or empty");
        }

        // 假设第一个元素是最大的
        E maxElement = list.get(0);

        // 遍历列表中的所有元素
        for (E element : list) {
            // 如果找到更大的元素，更新maxElement
            if (element.compareTo(maxElement) > 0) {
                maxElement = element;
            }
        }

        // 返回最大元素
        return maxElement;
    }
}
