import java.util.*;

public class DoubleArrayRounder {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        //get 5 doubles from the user

        //round each to the nearest int, and store all in an int array

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter a number with a decimal: ");
            arr[i] = NumberOps.round(s.nextDouble());
        }
        //print the median(of those ints)
        System.out.printf("Median of rounded ints: %.2f%n", NumberOps.median(arr));

    }
}