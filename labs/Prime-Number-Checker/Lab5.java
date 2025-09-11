import java.util.*;

public class Lab5{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter an integer greater than or equal to 2: ");
        int num = s.nextInt();
        boolean a = false;
        if ( num >= 2 ){
            for ( int i = 2 ; i <= Math.sqrt(num) ; i++ ){
                if ( num % i == 0){
                    int other_factor = num / i;
                    System.out.printf(" %d = %d * %d", num, i, other_factor);
                    a = true;
                    break;
                }
           
            }
            if ( a == false ){
                System.out.printf("%d is prime", num);
            }
        
        } else{
            System.out.printf("%d is an invalid input", num);
        }

        
    }
}
        

    

