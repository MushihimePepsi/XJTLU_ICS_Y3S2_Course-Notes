import java.util.Stack;

public class BracketChecker {
    public static void main(String[] args) {
        // 从键盘读取一行程序源代码
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a program source-code line:");
        String input = scanner.nextLine();

        // 检查括号是否配对
        System.out.println(isPaired(input) ? "Paired" : "Unpaired");
    }

    public static boolean isPaired(String expression) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty() || stack.pop() != getMatching(ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static char getMatching(char ch) {
        switch (ch) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: return 0;
        }
    }
}