import java.util.Comparator;

public class MergeSortExample {

    // 使用 Comparable 接口进行排序
    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            int middle = list.length / 2;
            @SuppressWarnings("unchecked")
            E[] firstHalf = (E[]) new Comparable[middle];
            @SuppressWarnings("unchecked")
            E[] secondHalf = (E[]) new Comparable[list.length - middle];

            System.arraycopy(list, 0, firstHalf, 0, middle);
            System.arraycopy(list, middle, secondHalf, 0, list.length - middle);

            mergeSort(firstHalf);
            mergeSort(secondHalf);

            merge(list, firstHalf, secondHalf);
        }
    }

    // 使用 Comparator 接口进行排序
    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        if (list.length > 1) {
            int middle = list.length / 2;
            @SuppressWarnings("unchecked")
            E[] firstHalf = (E[]) new Comparable[middle];
            @SuppressWarnings("unchecked")
            E[] secondHalf = (E[]) new Comparable[list.length - middle];

            System.arraycopy(list, 0, firstHalf, 0, middle);
            System.arraycopy(list, middle, secondHalf, 0, list.length - middle);

            mergeSort(firstHalf, comparator);
            mergeSort(secondHalf, comparator);

            merge(list, firstHalf, secondHalf, comparator);
        }
    }

    // 合并两个已排序的子数组
    private static <E extends Comparable<E>> void merge(E[] list, E[] firstHalf, E[] secondHalf) {
        int i = 0, j = 0, k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (firstHalf[i].compareTo(secondHalf[j]) <= 0) {
                list[k++] = firstHalf[i++];
            } else {
                list[k++] = secondHalf[j++];
            }
        }
        while (i < firstHalf.length) {
            list[k++] = firstHalf[i++];
        }
        while (j < secondHalf.length) {
            list[k++] = secondHalf[j++];
        }
    }

    // 合并两个已排序的子数组，使用 Comparator
    private static <E> void merge(E[] list, E[] firstHalf, E[] secondHalf, Comparator<? super E> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < firstHalf.length && j < secondHalf.length) {
            if (comparator.compare(firstHalf[i], secondHalf[j]) <= 0) {
                list[k++] = firstHalf[i++];
            } else {
                list[k++] = secondHalf[j++];
            }
        }
        while (i < firstHalf.length) {
            list[k++] = firstHalf[i++];
        }
        while (j < secondHalf.length) {
            list[k++] = secondHalf[j++];
        }
    }

    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        System.out.println("Original list: " + java.util.Arrays.toString(list));
        mergeSort(list);
        System.out.println("Sorted list using Comparable: " + java.util.Arrays.toString(list));

        String[] stringList = {"banana", "apple", "cherry", "date"};
        System.out.println("Original string list: " + java.util.Arrays.toString(stringList));
        mergeSort(stringList, (a, b) -> b.compareTo(a));
        System.out.println("Sorted string list using Comparator: " + java.util.Arrays.toString(stringList));
    }
}
