/**
 * A Java program that calculates statistics on temperature readings
 *
 * @author Sanskar Luitel
 * @version 4
 */
import java.util.*;

public class Proj4 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);

        //Requirement 1
        System.out.println();
        System.out.print("Enter a list of temperature readings, separated by spaces: ");
        String list = s.nextLine();
        String[] pieces = list.split(" ");
        int[] temps = new int[pieces.length];
        if (temps.length < 2) {
            System.out.println("Please enter at least two temperatures.");
            return;
        }

        for (int i = 0; i < pieces.length; i++) {
            temps[i] = Integer.parseInt(pieces[i]);
        } 


        int difference = 0;
        int temp1 = temps[0];
        int temp2 = temps[1];

        for (int i = 1; i < temps.length; i++) {
            int cur_difference = Math.abs(temps[i] - temps[i - 1]);

            if (cur_difference > difference) {
                difference = cur_difference;
                temp1 = temps[i - 1];
                temp2 = temps[i];
            }
        }
        System.out.println();
        System.out.printf("Maximum temperature difference: %d and %d%n", temp1, temp2);


        //Requirement 2
        int cur_length = 1;
        int longest_length = 1;
        int cur_start = 0;
        int longest_start = 0;

        for (int i = 0; i < temps.length - 1; i++) {
            if (temps[i + 1] > temps[i]) {
                cur_length++;
            } else {
                if (cur_length > longest_length) {
                    longest_length = cur_length;
                    longest_start = cur_start;
                }
                cur_length = 1;
                cur_start = i + 1;
            }
        }

        if (cur_length > longest_length) {
            longest_length = cur_length;
            longest_start = cur_start;
        }
        System.out.println();
        System.out.print("Longest increasing temperature section: ");
        for (int i = longest_start; i < longest_start + longest_length; i++) {
            System.out.print(temps[i] + " ");
        }
        System.out.println();
        System.out.println();

        //Requirement 3
        int [] counts = new int[temps.length];
        for (int i = 0; i < temps.length; i++) {
            counts[i] = 0; 
            for (int j = 0; j < temps.length; j++) {
                if (temps[j] == temps[i]) {
                    counts[i]++;
                }
            }
        }

        int max_count = counts[0];
        int most_frequent_temp = temps[0];

        for (int i = 1; i < counts.length; i++) {
            if (counts[i] > max_count) {
                max_count = counts[i];
                most_frequent_temp = temps[i];
            }
        }
        System.out.printf("The most frequent temperature was %d, which occurred %d times.%n", most_frequent_temp, max_count);

    }
}
    

