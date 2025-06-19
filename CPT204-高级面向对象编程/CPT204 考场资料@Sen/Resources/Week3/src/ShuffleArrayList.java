import java.util.ArrayList;
import java.util.Random;

public class ShuffleArrayList {
    public static void main(String[] args) {
        // 创建一个包含数字的ArrayList
        ArrayList<Number> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        // 打印原始列表
        System.out.println("Original list: " + list);

        // 调用shuffle方法打乱列表
        shuffle(list);

        // 打印打乱后的列表
        System.out.println("Shuffled list: " + list);
    }

    public static void shuffle(ArrayList<Number> list) {
        Random random = new Random(); // 创建一个随机数生成器

        // Fisher-Yates洗牌算法
        for (int i = list.size() - 1; i > 0; i--) {
            // 生成一个从0到i（包含i）的随机索引
            int j = random.nextInt(i + 1);

            // 交换索引i和j处的元素
            Number temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}
