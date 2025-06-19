public class Pair<E, F> {
    public E first; // 第一个元素
    public F second; // 第二个元素

    // 构造函数：初始化一个包含两个不同类型元素的Pair
    public Pair(E e, F f) {
        first = e;
        second = f;
    }

    public static void main(String[] args) {
        Pair<Integer, Double> p1 = new Pair<>(1, 85.5);
        Pair<Integer, String> p2 = new Pair<>(2, "good");
        print(p1);
        print(p2);
    }

    public static void print(Pair p) {
        System.out.println(p.first + " " + p.second);
    }
}
