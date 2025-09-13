/**
 * A Java program that calculates change using the fewest bills and coins.
 *
 * @author Sanskar Luitel
 * @version 3
 */
import java.util.*;

public class Proj3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        boolean condition = true;
        char input;

        do{
            System.out.print("Enter the total owed: $");
            double total_owed = s.nextDouble();
            s.nextLine();

            System.out.print("Enter the amount paid: $");
            double amount_paid = s.nextDouble();
            s.nextLine();

            if (total_owed < 0 || amount_paid < total_owed){
                System.out.println("Error: Total owed must be non-negative and amount paid must be at least total owed.");
            }else if (total_owed == amount_paid){
                System.out.println("No change");
            }else{
                double change = amount_paid - total_owed;
                System.out.printf("Your change is $%.2f, paid as:%n", change); 
            
                int cents = (int) Math.round(change*100);
            
                int twenties = cents / 2000;
                    cents %= 2000;

                int tens = cents / 1000;
                    cents %= 1000;

                int fives = cents / 500;
                    cents %= 500;

                int ones = cents / 100;
                    cents %= 100;

                int quarters = cents / 25;
                    cents %= 25;

                int dimes = cents / 10;
                    cents %= 10;

                int nickels = cents / 5;
                    cents %= 5;

                int pennies = cents;


            if ( twenties > 1){
                System.out.printf(" \t%d twenty dollar bills%n", twenties);
            } else if ( twenties > 0 ){
                System.out.printf(" \t%d twenty dollar bill%n", twenties);
            }


            if ( tens > 1){
                System.out.printf(" \t%d ten dollar bills%n", tens);
            }else if (tens > 0) {
                System.out.printf(" \t%d ten dollar bill%n", tens);
            }


            if ( fives > 1){
                System.out.printf(" \t%d five dollar bills%n", fives);
            }else if ( fives > 0 ){
                System.out.printf(" \t%d five dollar bill%n", fives);
            }


            if ( ones > 1){
                System.out.printf(" \t%d one dollar bills%n", ones);
            }else if ( ones > 0){
                System.out.printf(" \t%d one  dollar bill%n", ones);
            }


            if ( quarters > 1){
                System.out.printf(" \t%d quarters%n", quarters);
            }else if ( quarters > 0){
                System.out.printf(" \t%d quarter%n", quarters);
            }

            if ( dimes > 1){
                System.out.printf(" \t%d dimes%n", dimes);
            }else if( dimes > 0){
                System.out.printf(" \t%d dime%n", dimes);
            }

            if (nickels > 1){
                System.out.printf(" \t%d nickels%n", nickels);
            }else if (nickels > 0){
                System.out.printf(" \t%d nickel%n", nickels);
            }

            if (pennies > 1 ){
                System.out.printf(" \t%d pennies%n", pennies);
            }else if (pennies > 0){
                System.out.printf(" \t%d penny%n", pennies);
            }
            }
            while (true) {
                System.out.print("Would you like to go again? (y/n) ");
                String response = s.nextLine();

                if (response.length() == 1) {
                    input = response.charAt(0);

                    if (input == 'y' || input == 'Y') {
                        condition = true;
                        break;
                    } else if (input == 'n' || input == 'N') {
                        condition = false;
                        break;
                    }
                }
                System.out.println("Invalid input, please enter 'y' or 'n'.");
            }
        }while(condition);
    
    }
}
