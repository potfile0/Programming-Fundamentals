import java.util.Scanner;

public class Lab14 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Point p1 = new Point(-2, 7);

        System.out.print("Enter x-coordinate: ");
        double x2 = input.nextDouble();

        System.out.print("Enter y-coordinate: ");
        double y2 = input.nextDouble();

        Point p2 = new Point(x2, y2);

        // Print 
        System.out.println("\nBoth points:");
        p1.print();
        p2.print();

        // Midpoint
        Point mid = p1.midpoint(p2);
        System.out.println("\nMidpoint:");
        mid.print();

        // Quadrants
        System.out.println("\nQuadrant for first point: " + p1.quadrant());
        System.out.println("Quadrant for second point: " + p2.quadrant());
        System.out.println("Quadrant for midpoint: " + mid.quadrant());

    }
}
