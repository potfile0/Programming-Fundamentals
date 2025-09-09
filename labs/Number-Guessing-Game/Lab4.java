import java.util.*;

public class Lab4{

    public static void main (String[] args) {
        Scanner s = new Scanner ( System.in );
        Random r = new Random();
        System.out.println("I'm thinking of a number...");
        int random = r.nextInt(100)+1;
        System.out.print(random);
        int number_of_guesses = 1;
        do{
           System.out.print("Enter a guess: ");
            int guess = s.nextInt(); 
            
            if (guess == random){
                System.out.printf("Correct! It took you %d guesses.", number_of_guesses);
                break;
            }
            if (guess < random){
                System.out.println("Nope, too low");
                
            }
            if (guess > random){
                System.out.println("Nope, too high");
                
            }
            number_of_guesses+=1;
        } while (number_of_guesses<11);
        if ( number_of_guesses == 11 ){
        System.out.println("Out of time...you've used your 10 guesses.");
        }

    }
}