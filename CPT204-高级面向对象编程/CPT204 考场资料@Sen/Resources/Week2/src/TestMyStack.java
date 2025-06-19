import java.util.Scanner;

public class TestMyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter five strings:");
        for (int i = 0; i < 5; i++) {
            stack.push(scanner.nextLine());
        }

        scanner.close();

        System.out.println("Strings in reverse order:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
