import java.util.Scanner;

public class Exercise_1_1 {
    public static void reverseInPlace(double[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            double temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = Integer.parseInt(sc.nextLine());
        double[] arr = new double[size];

        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextDouble();
        }

        reverseInPlace(arr);

        System.out.print("The reversed array is: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }
}

