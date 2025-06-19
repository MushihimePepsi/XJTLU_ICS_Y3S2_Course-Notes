public class Exam implements CPT204 {
    public int cpt204() { return 204; }
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");
        System.out.println(s1.equals(s2));
    }
}