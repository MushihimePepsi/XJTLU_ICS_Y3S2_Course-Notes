import java.util.*;

public class Test {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        System.out.println(set.contains(1));
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        System.out.println(list.contains(1));
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        System.out.println(stack.contains(1));
        Map<Integer,Integer> map = new LinkedHashMap<>();
    }
}