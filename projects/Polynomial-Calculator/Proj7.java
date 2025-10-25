import java.util.*;

public class Proj7 {

    public static Scanner s = new Scanner(System.in);

    //make new polynomial by asking user
    public static Polynomial buildPoly(String name) {
        System.out.println("Input for " + name + " polynomial.");
        System.out.print("Enter degree of polynomial: ");
        int deg = s.nextInt();

        Polynomial p = new Polynomial(deg); //new polynomial

        for (int i = deg; i >= 0; i--) {
            if (i == 0) System.out.print("Enter constant term: ");
            else if (i == 1) System.out.print("Enter coefficient for x: ");
            else System.out.print("Enter coefficient for x^" + i + ": ");

            int coeff = s.nextInt();
            p.setTerm(coeff, i);
        }
        System.out.println();
        return p;
    }
    public static void main(String[] args) {
        //make 2 polys
        Polynomial poly1 = buildPoly("first");
        Polynomial poly2 = buildPoly("second");

        //print first poly
        System.out.println("First polynomial: " + poly1);
        for (int x = 1; x <= 5; x++) {
            System.out.println("\tEvaluated at x=" + x + ": " + poly1.eval(x));
        }
        System.out.println();

        //print second poly
        System.out.println("Second polynomial: " + poly2);
        for (int x = 1; x <= 5; x++) {
            System.out.println("\tEvaluated at x=" + x + ": " + poly2.eval(x));
        }
        System.out.println();

        //add polys
        Polynomial sum = poly1.add(poly2);
        System.out.println("(" + poly1 + ") + (" + poly2 + ") = " + sum);
        System.out.println();

        //multiply polys
        Polynomial prod = poly1.multiply(poly2);
        System.out.println("(" + poly1 + ") * (" + poly2 + ") = " + prod);
        System.out.println();

        //derivative of product
        Polynomial der = prod.deriv();
        System.out.println("Derivative of " + prod + " is " + der);
    }
}
