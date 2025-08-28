import java.util.*;

public class lab2 {
	public static void main(String[] args){
	Scanner s = new Scanner (System.in);
	System.out.print("Enter the bill: $");
	double bill = s.nextDouble();

	double calculated_tip = 0.18 * bill ;
	System.out.printf("An 18%% tip would be: $%.2f%n" , calculated_tip);
	}
}