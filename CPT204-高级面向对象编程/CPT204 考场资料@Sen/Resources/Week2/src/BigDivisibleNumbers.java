import java.math.BigInteger;

public class BigDivisibleNumbers {
    public static void main(String[] args) {
        printNumbers();
    }

    public static void printNumbers() {
        // 定义50位数的最小值（10^49）
        BigInteger current = BigInteger.TEN.pow(49);
        // 定义常量大数2和3，用于取模运算
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger THREE = BigInteger.valueOf(3);

        int count = 0;
        while (count < 10) {
            // 检查是否能被2或3整除
            if (current.mod(TWO).equals(BigInteger.ZERO) ||
                    current.mod(THREE).equals(BigInteger.ZERO)) {
                // 转换为字符串并补零（确保输出为50位）
                String numStr = current.toString();
                System.out.println(numStr);
                count++;
            }
            current = current.add(BigInteger.ONE); // 递增
        }
    }
}