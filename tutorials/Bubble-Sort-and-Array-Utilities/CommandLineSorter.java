import java.util.*;

public class CommandLineSorter {
    public static void main(String[] args) {

        //unknown number of command line arguments (integers)
        //store in an int array

        if(args.length > 0) {
            //they must have included command line arguments

            //unknown number of command line arguments (integers)
            //store in an int array

            int[] arr = new int[args.length];
            for(int i = 0; i < args.length; i++) {
                arr[i] = Integer.parseInt(args[i]);
            }

            //sort the array
            NumberOps.bubbleSort(arr);

            //print the array
            NumberOps.printArray(arr);

        }
        else {
            System.out.println("Error. Run as java CommandLineSorter int1 int2 ... intn");
        }
    }
}