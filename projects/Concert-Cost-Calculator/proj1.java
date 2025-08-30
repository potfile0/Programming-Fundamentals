/**
 * (A Java program that calculates the cost for a family attending concert.)
 *
 * @author (Sanskar Luitel)
 * @version (1)
 */
import java.util.*;

public class proj1{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.print("This program calculates the total price for a concert.\n");
        System.out.print("\n");
        System.out.print("It makes the folowing assumptions:\n");
        System.out.print("\t Adult ticket cost: $59.99 each\n");
        System.out.print("\t Child ticket cost: $39.99 each\n");
        System.out.print("\t T-shirt cost: $14.99 each\n");
        System.out.print("\t Sales tax rate: 9.5%\n");
        System.out.print("Enter number of adult tickets: ");
        int adult = s.nextInt();

        System.out.print("Enter number of child tickets: ");
        
        int child = s.nextInt();

        int total_ticket_num = adult + child;

        double total_ticket = ( adult * 59.99 ) +  ( child * 39.99);

        double total_shirt = total_ticket_num * 14.99;

        double cp_beforetax = total_ticket + total_shirt;
        double cp_aftertax = (0.095 * cp_beforetax) + cp_beforetax;
        System.out.print("\n");
        System.out.printf("Total ticket cost: $%.2f%n", total_ticket );
        System.out.printf("Total shirt cost: $%.2f%n", total_shirt);
        System.out.printf("Overall cost before tax: $%.2f%n", cp_beforetax);
        System.out.printf("Overall cost after tax: $%.2f%n", cp_aftertax);

    }
}