import java.util.Arrays;
import java.util.List;

public class ARDeque<T> extends java.util.LinkedList<T> {
    private static final long serialVersionUID = 1L;

    public ARDeque(List<T> list) {
        super(list);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (!(that instanceof ARDeque)) {
            return false;
        }
        ARDeque<?> other = (ARDeque<?>) that;
        if (this.size() != other.size()) {
            return false;
        }
        int differences = 0;
        for (int i = 0; i < this.size(); i++) {
            if (!this.get(i).equals(other.get(i))) {
                differences++;
                if (differences > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ARDeque<Integer> deque1 = new ARDeque<>(Arrays.asList(1, 2, 3));
        ARDeque<Integer> deque2 = new ARDeque<>(Arrays.asList(1, 2, 5));
        ARDeque<Integer> deque3 = new ARDeque<>(Arrays.asList(1, 3, 2));

        System.out.println(deque1.equals(deque2)); // true
        System.out.println(deque1.equals(deque3)); // false
    }
}