import java.util.Comparator;

public class InsertionSortExample {

    // 使用 Comparable 接口进行排序
    public static <E extends Comparable<E>> void insertionSort(E[] list) {
        for (int i = 1; i < list.length; i++) {
            E current = list[i];
            int j = i - 1;
            while (j >= 0 && list[j].compareTo(current) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = current;
        }
    }

    // 使用 Comparator 接口进行排序
    public static <E> void insertionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            E current = list[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(list[j], current) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        System.out.println("Original list: " + java.util.Arrays.toString(list));
        insertionSort(list);
        System.out.println("Sorted list using Comparable: " + java.util.Arrays.toString(list));

        String[] stringList = {"banana", "apple", "cherry", "date"};
        System.out.println("Original string list: " + java.util.Arrays.toString(stringList));
        insertionSort(stringList, (a, b) -> b.compareTo(a));
        System.out.println("Sorted string list using Comparator: " + java.util.Arrays.toString(stringList));
    }
}
