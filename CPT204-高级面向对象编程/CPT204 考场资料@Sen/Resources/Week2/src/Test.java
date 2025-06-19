public class Test {
    public static void main(String[] args) {
        B a = new A();
        a.p(10.0);
        a.p(10);
    }
}

class B {
    public void p(double i) {
        System.out.println(i * 2);
    }
}

class A extends B {
    public void p(int i) {
        System.out.println(i);
    }
}
