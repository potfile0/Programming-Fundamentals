import java.util.*;

public class Tutorial6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        printHello();
        System.out.println("This is a tutorial");
        printHello();

        int[] nums = {5,10,15,1,2,12};
        printBetweenRange(nums, 5, 15);

        int answer = findExponent(2,3);
        System.out.println("2^3 = " + answer);

        //get smallest in nums
        System.out.printf("Smallest is %d%n", min(nums));

        String[] wordExamples = {"birthday", "abracadabra", "final", "tutorials", "week", "semester"};
        //first, get the corresponding array of lengths
        //then, print the lengths that are between 8 and 10

        
        printBetweenRange(getWordLengths(wordExamples), 8, 10);
    }

    //public static returnType methodName(paramType paramName, ...) 

    //Example 1: method that prints Hello

    public static void printHello() {
        System.out.println("Hello");
    }

    //Example 2: method that prints elements in an int array that are between 5 and 10

    public static void printBetweenRange(int[] arr, int lower, int upper) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= lower && arr[i] <= upper) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    //Example 3: method that finds an exponent
    //2^3 = 2*2*2
    public static int findExponent(int base, int exponent) {
        int product = 1;
        for (int i = 0; i < exponent; i++) {
            product *= base;
        }
        return product;
    }

    //Example 4: method that returns the min between two elements
    public static int min(int x, int y) {
        if (x < y){
            return x;
        }
        else {
            return y;
        }
    }

    //Example 5: method that returns the min element in an array (see Tutorial 4)
    public static int min (int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (arr [i] < min ) {
                min = arr[i];
            }
        }

        return min;
    }

    //Example 6: method that takes an array of strings and return an array of lengths
    //{"apple", "banana", "kumquat"}
    //{5, 6, 7}
    public static int[] getWordLengths(String[] words) {
        int[] wordLengths = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            wordLengths[i] = words[i].length();
        }
        return wordLengths;
    } 


}
