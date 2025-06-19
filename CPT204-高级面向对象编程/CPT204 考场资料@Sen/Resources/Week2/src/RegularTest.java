public class RegularTest {
    public static void main(String[] args) {
        String phoneNumber = "(123) 456-7890";
        boolean matches = phoneNumber.matches("\\([1-9]\\d{2}\\) \\d{3}-\\d{4}");
        System.out.println(matches); // 输出 true
    }
}
