import java.util.*;

public class Lab6 {
    public static void main (String[] args){
        Scanner s = new Scanner (System.in);  
        int input_is_odd;
        int input_is_even;
        int sum = 0;
        
        for ( int i = 1; i < 6; i++){
            System.out.print("Enter a number that is >10: ");
            int input = s.nextInt();
            
            if ( input < 10 ){
                System.out.printf("Error: %d is not > 10\n", input);
            }
            else {
                sum += input;
                System.out.printf("The odd number <= %d are: \n", input);

                if ( input % 2 == 1) {
                    for ( input_is_odd = input; input_is_odd >= 1; input_is_odd -= 2 ){
                        System.out.println(input_is_odd);
                        
                    }
                }

                if ( input % 2 == 0) {
                    for ( input_is_even = input - 1; input_is_even >=1; input_is_even -= 2){
                        System.out.println(input_is_even);
                        
                }
            }
            
        }
            
        

    }
    System.out.printf("The sum of the 5 numbers entered that are >10 is: %d\n", sum);
    }
}
