public class Calculator {
    public static void main(String[] args) {
        // 检查参数数量是否正确
        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(0);
        }

        int result = 0;
        try {
            // 将操作数转换为整数
            int operand1 = Integer.parseInt(args[0]);
            int operand2 = Integer.parseInt(args[2]);

            // 根据操作符进行计算
            switch (args[1].charAt(0)) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    // 检查除数是否为零
                    if (operand2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Invalid operator: " + args[1]);
                    System.exit(1);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + e.getMessage());
            System.exit(1);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }

        // 打印结果
        System.out.println("Result: " + result);
    }
}
