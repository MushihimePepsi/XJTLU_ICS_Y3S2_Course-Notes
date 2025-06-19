import java.util.Scanner;

public class Exercise_1_2 {
    public static boolean isConsecutiveFour(int[] values){
        int len = values.length;
        if(len < 4){
            return false;
        }
        else{
            for (int i = 0; i < len - 3; i++){
                if (values[i] == values[i + 1] && values[i] == values[i + 2] && values[i] == values[i + 3]){
                    return true;
                }
            }
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int size = Integer.parseInt(sc.nextLine());
        int[] arr = new int[size];
        System.out.println("Enter the elements in the array: ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        boolean isConsecutive = isConsecutiveFour(arr);
        if(isConsecutive){
            System.out.println("Consecutive");
        }
        else {
            System.out.println("Not Consecutive");
        }
    }
}

