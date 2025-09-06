/**
 * a Java program that implements a basic federal income tax calculator
 * will simplify federal tax rules to assume the user has a "single" filing status.
 * only consider the gross income and the standard deduction
 * @author Sanskar Luitel
 * @version 2
 */
import java.util.*;

public class Proj2{
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);

        System.out.print("Enter your gross income from 2024: $");
        int gross_income = s.nextInt();
        int taxable_income = gross_income - 14600;
        double tax = 0.0;
        if ( taxable_income > 609351  ) {
            double over = taxable_income - 609351;
            double curTax = over * 0.37;
            tax += curTax;
            taxable_income = 609351;
        }
        if ( taxable_income > 243726 ){
            double over = taxable_income - 243726;
            double curTax = over * 0.35;
            tax += curTax;
            taxable_income = 243726;
        }
        if ( taxable_income > 191951 ){
            double over = taxable_income - 191951;
            double curTax = over * 0.32;
            tax += curTax;
            taxable_income = 191951;
        }
        if ( taxable_income > 100526 ){
            double over = taxable_income - 100526;
            double curTax = over * 0.24;
            tax += curTax;
            taxable_income = 100526;
        }
        if ( taxable_income > 47151 ){
            double over = taxable_income - 47151;
            double curTax = over * 0.22;
            tax += curTax;
            taxable_income= 47151;
        }
        if (taxable_income > 11601){
            double over = taxable_income - 11601;
            double curTax = over * 0.12;
            tax += curTax;
            taxable_income = 11601;
        }
        if ( taxable_income > 0 ){
            double curTax = taxable_income * 0.10;
            tax += curTax;
        }
        int rounded_tax_amount = (int)(Math.round(tax));
        System.out.printf("Taxes owed if filing as single: $%,d%n",rounded_tax_amount);
    }
}