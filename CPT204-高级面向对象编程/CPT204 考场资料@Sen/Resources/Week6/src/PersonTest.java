import java.util.HashSet;
import java.util.Set;

public class PersonTest {
    public static void main(String[] args) {
        // 在另一个类中使用 Person 类
        Set<Person> set1 = new HashSet<>();
        set1.add(new Person("John", 19));
        set1.add(new Person("Mary", 20));
        set1.add(new Person("John", 19));
        System.out.println(set1);
    }
}
