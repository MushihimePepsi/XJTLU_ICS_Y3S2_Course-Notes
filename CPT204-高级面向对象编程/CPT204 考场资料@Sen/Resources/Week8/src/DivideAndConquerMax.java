public class DivideAndConquerMax {
    public static int findMax(int[] list) {
        return findMaxRecursive(list, 0, list.length - 1);
    }

    private static int findMaxRecursive(int[] list, int left, int right) {
        if (left == right) {
            return list[left]; // 基本情况：只有一个元素
        } else if (left + 1 == right) {
            return Math.max(list[left], list[right]); // 两个元素，直接比较
        } else {
            int mid = (left + right) / 2;
            int maxLeft = findMaxRecursive(list, left, mid);
            int maxRight = findMaxRecursive(list, mid + 1, right);
            return Math.max(maxLeft, maxRight); // 比较左右两部分的最大值
        }
    }

    public static void main(String[] args) {
        int[] list = {178, 33, 4, 2, -3, 5};
        System.out.println("The largest number is: " + findMax(list));
    }
}
