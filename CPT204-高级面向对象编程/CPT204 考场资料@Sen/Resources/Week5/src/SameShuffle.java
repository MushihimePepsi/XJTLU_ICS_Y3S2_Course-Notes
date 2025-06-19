import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SameShuffle {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("yellow", "red", "green", "blue");
        List<String> list2 = Arrays.asList("Y", "R", "G", "B");
        Collections.shuffle(list1, new Random(20));
        Collections.shuffle(list2, new Random(20));
        System.out.println(list1);
        System.out.println(list2);
    }
}
