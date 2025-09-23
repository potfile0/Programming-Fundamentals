import java.util.*;

public class Lab7 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = new int[10];
        int count = 0;

        System.out.print("Enter a list of up to 10 temperatures separated by spaces, terminating with -1:\n");

        for (int i = 0; i < arr.length; i++) {
            int temp = s.nextInt();
            if (temp == -1) {
                break;
            }
            arr[count] = temp;
            count++;
        }

        System.out.println("Here are the temperatures that were below freezing (32 degrees):");

        for (int i = 0; i < count; i++) {
            if (arr[i] < 32) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println(); 
    }
}
