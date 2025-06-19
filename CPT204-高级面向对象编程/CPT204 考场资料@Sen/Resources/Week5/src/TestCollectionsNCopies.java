import java.util.*;

public class TestCollectionsNCopies {
    public static void main(String[] args) {
        List<Calendar> list1 = Collections.nCopies(3, new GregorianCalendar(2022, Calendar.JANUARY, 1));

        System.out.println(list1); // 输出: [Sun Jan 01 2022 00:00:00:00 GMT, Sun Jan 01 2022 00:00:00:00 GMT, Sun Jan 01 2022 00:00:00 GMT]
    }
}