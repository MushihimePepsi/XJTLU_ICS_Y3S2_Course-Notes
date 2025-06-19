//import java.lang.*;
//
//public class Rational extends Number implements Comparable<Rational> {
//    private long numerator = 0;
//    private long denominator = 1;
//
//    public Rational() { this(0, 1); }
//    public Rational(long numerator, long denominator) {
//        long gcd = gcd(numerator, denominator);
//        this.numerator = (denominator > 0 ? 1 : -1) * numerator / gcd;
//        this.denominator = Math.abs(denominator) / gcd;
//    }
//
//    private static long gcd(long n, long d) {
//        long n1 = Math.abs(n);
//        long n2 = Math.abs(d);
//        int gcd = 1;
//        for (int k = 1; k <= n1 && k <= n2; k++) {
//            if (n1 % k == 0 && n2 % k == 0)
//                gcd = k;
//        }
//        return gcd;
//    }
//
//    public Rational add(Rational secondRational) {
//        long n = numerator * secondRational.getDenominator() +
//                denominator * secondRational.getNumerator();
//        long d = denominator * secondRational.getDenominator();
//        return new Rational(n, d);
//    }
//
//    public Rational subtract(Rational secondRational) {
//        return add(secondRational.negate());
//    }
//
//    public Rational negate() {
//        return new Rational(-numerator, denominator);
//    }
//
//    public Rational multiply(Rational secondRational) {
//        long n = numerator * secondRational.getNumerator();
//        long d = denominator * secondRational.getDenominator();
//        return new Rational(n, d);
//    }
//
//    public Rational divide(Rational secondRational) {
//        return multiply(secondRational.reciprocal());
//    }
//
//    public Rational reciprocal() {
//        return new Rational(denominator, numerator);
//    }
//
//    @Override
//    public int intValue() { return (int)doubleValue(); }
//
//    @Override
//    public long longValue() {
//        return 0;
//    }
//
//    @Override
//    public float floatValue() {
//        return 0;
//    }
//
//    public double double doubleValue() { return ((double)numerator)/denominator; }
//
//    // ... Override all the abstract *Value methods in java.lang.Number
//
//    @Override
//    public int compareTo(Rational o) {
//        if ((this.subtract(o)).getNumerator() > 0) return 1;
//        else if (this.subtract(o).getNumerator() < 0) return -1;
//        else return 0;
//    }
//
//    public static void main(String[] args) {
//        Rational r1 = new Rational(1, 2);
//        Rational r2 = new Rational(2, 3);
//        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
//    }
//}
