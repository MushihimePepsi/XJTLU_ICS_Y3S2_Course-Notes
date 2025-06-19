import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class DelimitedARDeque<T> extends ArrayDeque<T> {
    private Set<T> elementSet = new HashSet<>();

    @Override
    public void addFirst(T item) {
        if (!elementSet.add(item)) {
            throw new IllegalArgumentException("Item already occurs more than once.");
        }
        super.addFirst(item);
    }

    public void printDeque() {
        System.out.println(this);
    }

    public static void main(String[] args) {
        DelimitedARDeque<String> dd = new DelimitedARDeque<>();
        dd.addFirst("a");
        dd.addFirst("b");
        try {
            dd.addFirst("a");
            dd.printDeque();
        } catch (IllegalArgumentException e) {
            System.out.println("AddFirst failed");
        }
    }
}