public class Overloading {
    public static int max(int num1, int num2) {
        if (num1 > num2) return num1;
        return num2;
    }

    public static double max(double num1, double num2) {
        if (num1 > num2) return num1;
        return num2;
    }

    public static void main(String[] args) {
        System.out.println(max(1, 2)); // 调用第一个max方法，参数类型为int
        System.out.println(max(1, 2.3)); // 调用第二个max方法，参数类型为double
    }
}