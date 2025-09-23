import java.util.*;

public class Stats{
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        //get 10 numbers from user, report min/max/avg

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++ ){
            System.out.print("Enter number: ");
            arr[i] = s.nextInt();
        }

        double sum = arr[0];
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        //print stats
        double avg = sum / arr.length;
        System.out.printf("Average: %.2f%n", avg);
        System.out.printf("Minimum: %d%n", min);
        System.out.printf("Maximum: %d%n", max);
        
    }
}