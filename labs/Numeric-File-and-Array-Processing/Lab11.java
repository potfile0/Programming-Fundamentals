import java.util.*;
import java.io.*;

public class Lab11 {
    public static void main(String[] args) throws IOException {

        Scanner inFile = new Scanner(new File("lab11nums.txt"));

        int lineNumber = 1;
        int overallSum = 0;

        while (inFile.hasNextLine()) {
            String line = inFile.nextLine();

            int[] numbers = stringToNumArray(line);
            int sum = sumOfArray(numbers);
            int range = rangeOfElements(numbers);

            System.out.printf("Line %d: sum %d, range %d%n", lineNumber, sum, range);

            overallSum += sum;
            lineNumber++;
        }

        System.out.println("\nOverall sum: " + overallSum);
        inFile.close();


    }

    // Convert string as parameter to integer array
    public static int[] stringToNumArray(String str) {
        String[] splitted_str = str.trim().split("\\s+"); 
        int[] arr = new int[splitted_str.length];
        for (int i = 0; i < splitted_str.length; i++) {
            arr[i] = Integer.parseInt(splitted_str[i]);
        }
        return arr;
    }

    // Find sum of elements
    public static int sumOfArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Range of elements in the array
    public static int rangeOfElements(int[] arr) {
        if (arr.length == 0) return 0;

        int smallest_num = arr[0];
        int largest_num = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest_num) {
                smallest_num = arr[i];
            }
            if (arr[i] > largest_num) {
                largest_num = arr[i];
            }
        }

        return largest_num - smallest_num;
    }

}
