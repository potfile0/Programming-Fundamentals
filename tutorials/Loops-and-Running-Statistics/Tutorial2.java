import java.util.*;

public class Tutorial2{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //Example 1: redo FizzBuzz example from tutorial 1
        //basically, do what we already did (FizzBuzz/Fizz/Buzz/number itself) for every number from 1 to the input

        //Example 1: FizzBuzz
        //get a positive integer from the user
        //for 1 up to the input: 
            //print "FizzBuzz" if the number is divisible by both 3 and 5
            //print "Fizz" if the number is divisible by 3 but not 5
            //print "Buzz" if the number is divisible by 5 but not 3
            //print the number itself if the number isn't divisible by either 3 or 5
        
        //16 - would print 16 itself
        //25 - would print "Buzz"
        //30  - would print "FizzBuzz"
        /*
        System.out.print("Enter a positive integer: ");
        int num = s.nextInt();
        //input validation
        if ( num >= 1) {
            //make a variable to track our current number
            for (int cur = 1; cur <= num; cur++ ) {
                if ( cur % 3 == 0 && cur % 5 == 0 ) {
                    System.out.println("FizzBuzz");
                }
                else if ( cur % 3 == 0 ){
                    System.out.println("Fizz");
                }
                else if ( cur % 5 == 0){
                    System.out.println("Buzz");
                }
                else {
                    System.out.println(cur);
                }
            }
        }else{
            System.out.printf("Error. %d is not positive (needs to be 1 or bigger).", num);
        }
        */

        //Example 2: want to repeatedly get numbers from the user (until they want to stop)
        //afterwards, print min/max/average

        //how many numbers entered
        int count = 0;

        //sum of all entered numbers
        double sum = 0;

        //smallest so far
        int min = 0;

        //biggest so far
        int max = 0;

        //change: what if we want only positives? (want to IGNORE any negatives)


        char again = 'y';
        do {
            //get number from the user
            System.out.print("Enter a positive number: ");
            int val = Integer.parseInt(s.nextLine()); //"1"

            //skip any positives
            /*
            if(val <= 0){
                System.out.println("Error. Inputs must be positive.");
                continue;
            }
            */

            //if they enter a negative, leave early and print results
            if ( val <= 0 ) {
                System.out.println("Negative number entered. Quitting early.");
                break;
            }

            //increase count of how many numbers entered
            count++;

            //add new user input onto my sum
            sum += val;

            //is this the first number? Otherwise, is the new number bigger than my max?
            if (count == 1 ) {
                max = val;
            }
            else if (val > max) {
                max = val;
            }

            //is this the first number? Otherwise, is the new number smaller than my min?
            if (count == 1 ) {
                min = val;
            }
            else if (val < min) {
                min = val;
            }
            

            //ask if they have another number
            System.out.print("Do you have another number? (y/n)");
            again = (s.nextLine().toLowerCase()).charAt(0); //YES -> yes -> y
            
        }while ( again == 'y' );

        System.out.println();
        System.out.printf("You entered %d positive numbers.%n", count);
        System.out.printf("The average is: %.2f%n", sum/count);
        System.out.printf("The maximum is: %d%n", max);
        System.out.printf("The minimum is: %d%n", min);
    }
}