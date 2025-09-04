/*
 * This program calculates the total cost of a pizza order 
 * 
 * @author Sanskar Luitel
 * @version Lab3
 */
import java.util.*;

public class Lab3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of pizzas (0-10): ");
        int number = s.nextInt();
        double pre_tax_total = 0.0;
        
        if (number >= 0 && number <= 10) {
            if (number <= 4){
                pre_tax_total = number * 12.99;
            } else {
                pre_tax_total = (4 * 12.99) + ((number - 4) * 9.99);
            }

            System.out.printf("Pre-tax total: $%.2f%n", pre_tax_total);

            double tip = 0.2 * pre_tax_total;
            System.out.printf("Tip amount: $%.2f%n", tip);

            double tax = 0.095 * pre_tax_total;
            double whole_total = pre_tax_total + tip + tax;
            System.out.printf("Overall total, including tax and tip: $%.2f%n", whole_total);
        } else {
            System.out.println("Error: number of pizzas must be 0-10");
        }
    }
}
