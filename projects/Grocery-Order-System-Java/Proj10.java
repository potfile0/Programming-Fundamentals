/**
 * This is the main class for the grocery project. It creates either
 * a standard or random order and prints out all items, totals, and savings.
 * 
 * @author Sanskar Luitel
 * @version Project 10
 * Lab Section Tue/Thur 1:05-2:45PM
 */
public class Proj10 {
    public static void main(String[] args) {

        if (args.length != 1 || 
            !(args[0].equals("--standard") || args[0].equals("--random"))) {
            System.out.println("Error, Please use: java Proj10 --standard OR --random");
            return;
        }

        boolean standard = args[0].equals("--standard");

        GroceryOrder order = new GroceryOrder(standard);

        System.out.println("GROCERY ORDER");
        for (GroceryItem g : order.getAllItems()) {
            System.out.println(g);
        }

        System.out.printf("\nTotal before discounts: $%.2f\n",
                order.getTotalFullPrice());

        System.out.printf("Total after discounts: $%.2f\n",
                order.getTotalDiscountPrice());

        System.out.printf("Total savings: $%.2f\n\n",
                order.getSavings());


        System.out.println("COUNTABLE ITEMS");
        for (CountableItem c : order.getCountableItems()) {
            System.out.println(c);
        }

        System.out.println("\nDISCOUNTED ITEMS");
        for (DiscountedItem d : order.getDiscountedItems()) {
            System.out.println(d);
        }
    }
}
